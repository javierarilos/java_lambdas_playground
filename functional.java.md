# "Functional" programming with Java 8




```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
```
---

# Iterating over a List

The typical **`for`** loop:

```Java
for (int i = 0; i < numbers.length; i++) {
  System.out.println(numbers.get(i));
}
```

The **`foreach`** loop:
```Java
for (int x : numbers) {
  System.out.println(x);
}
```

Both loops are known as **`external loops`**, since Java 8, Lists and other Iterable objects, have a `forEach` method that is known as an `internal loop`.

---

# Improved List iteration

Internal looping allows us to concentrate on `what` to do instead of `how` to do it. If we combine this with the new `Java 8 lambdas` the result is:

```Java
numbers.forEach(
    n -> System.out.println(n)
);
```

`Lambdas` are anonymous functions, that were added in Java 8. Some lambda examples:

```Java
() -> true;

(a, b) -> a + b;

n -> n * n;

(Integer a, String b) -> {
            String aString = "" + a;
            return b + aString;
        };
```

---
# So, is Java 8 a Functional language?

But, we are here to talk about Functional Programming (FP from now on).

FP is a lot of different things, and not even experts agree in a clear frontier on if a language is Functional or not.

For example, all FP gurus agree that Haskell is a FP language, but some claim that Javascript allows to do FP, while others say that is just an abomination.

---
# About functions in FP

There are some core capabilities in all Functional languages, that all experts agree that are mandatory for FP.

One of them is **`First class functions`**, and this refers to the capability of having functions handled as any other object in the language.

First class functions can:
* Be assigned to a variable
* Be passed to another function as a parameter
* Be the result of another function or method call

This, can be achieved with `Java lambda functions`.

---
# Java: everything belongs to a class

Before Java 8, our iteration would need an `inner class`.
```Java
numbers.forEach(
  new Consumer<Integer>() {
    @Override
    public void accept(Integer n) {
      System.out.println(n);
    }
  }
);
```

So, since everything belongs to a class, how are `lambdas` implemented?

---
# Java 8 interfaces

There are two big changes on how interfaces work in Java 8:
* Interfaces with behavior: `default` and `static` methods.
* `functional` interfaces: interfaces with a single method.

How this enable the `functional` changes in Java 8?

**`lambdas` are just syntactic sugar**: they are an anonymous instance of a functional interface. Compiler does the trick.


Existing classes can be extended without modifying them by using default and static methods in interfaces: **Backwards compatibility**

---

# Lambdas in action: Word count sorted by frequency (1)

```Java

Map wordCount = Files.lines(filePath)
        .map(removePunctuation)
        .flatMap(splitWords)
        .collect(lowerCaseWordsCount);


wordCount.entrySet().stream()
        .sorted(Map.Entry.comparingByValue().reversed())
        .forEach(System.out::println);

```

---

# Lambdas in action: Word count sorted by frequency (2)

```Java

Function<String, String> removePunctuation = s -> s.replaceAll("(?!')\\p{P}", "");

Function<String, Stream<String>> splitWords = s -> whites.splitAsStream(s);

Collector<String, ?, TreeMap<String, Long>> lowerCaseWordsCount =
        Collectors.groupingBy(
                              String::toLowerCase, // how to group
                              TreeMap::new,        // accumulator map factory
                              Collectors.counting()// reduce function
                          );

```

---

# Lambdas in action: Mailer (classic Java)

```Java
Mailer mailer = new Mailer();
mailer.from("mike@ioindustres");
mailer.to("sarah@ioindustres");
mailer.subject("Your code really sucks");
mailer.body("sucks... sucks... sucks... ");
mailer.send();
```

This code has two problems:
* noise: mailer, mailer, mailer, mailer, mailer, mailer...
* Resource management: should we reuse the Mailer instance?

---

# Lambdas in action: Mailer (fluid Java)

```Java

new Mailer()
        .from("mike@ioindustres")
        .to("sarah@ioindustres")
        .subject("Your code really sucks")
        .body("sucks... sucks... sucks... ")
        .send();
```

---

# Lambdas in action: Mailer (lambda compose)

```Java

Mailer.send(mailer ->
                    mailer
                        .from("mike@ioindustres")
                        .to("sarah@ioindustres")
                        .subject("Your code really sucks")
                        .body("sucks... sucks... sucks... "));
```

---

# Lambdas in action: Mailer (Mailer.send)

```Java

Mailer.send(mailer ->
                    mailer
                        .from("mike@ioindustres")
                        .to("sarah@ioindustres")
                        .subject("Your code really sucks")
                        .body("sucks... sucks... sucks... "));
```
So the Mailer.send is:
```Java

public static void send(Consumer<MailerV3> mailerTransform) {
    MailerV3 mailer = new MailerV3();
    mailerTransform.accept(mailer);
    System.out.println("... Sending ... ");
}

```



---

# Lambdas in action: Resource mgmt

```Java
Resource resource = new Resource();
resource.op1();
resource.op2();
resource.close();
```

This code has two problems:
* easy to forget the **`close()`** call
* **`close()`** not called on a exception

---

# Lambdas in action: Resource mgmt ARM
ARM - Automatic Resource Management

```Java
try (Resource resource = new Resource()) {
    resource.op1();
    resource.op2();
}
```

---

# Lambdas in action: Resource Around Pattern

```Java
ResourceExecuteAroundPattern.use(resource -> {
    resource.op1()
            .op2();
});
```

---

# Lambdas in action: Resource Around Pattern (2)

```Java
ResourceExecuteAroundPattern.use(resource -> {
    resource.op1()
            .op2();
});
```

```Java
public static void use(Consumer<ResourceExecuteAroundPattern> resourceOperations) {
    Resource resource = new Resource();
    try {
        resourceOperations.accept(resource);
    } finally {
        resource.close();
    }
}
```


---
# THAT'S ALL
<img style="display: block; margin-left: auto; margin-right: auto; width:60%;height:60%;" src="200w_d.gif">
