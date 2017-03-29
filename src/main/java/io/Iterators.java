package io;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.BiFunction;

public class Iterators
{
    public static void main( String[] args )
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        System.out.println( "----- EXTERNAL ITERATORS: FOR" );

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println( "----- EXTERNAL ITERATORS: FOREACH" );

        for (int current :numbers) {
            System.out.println(current);
        }

        System.out.println( "----- INTERNAL ITERATOR with anonymous Consumer object" );

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        });

        BiFunction<Integer, String, String> x = (Integer a, String b) -> {
            String aString = "" + a;
            return b + aString;
        };

        System.out.println(x.apply(88, "My age is: "));



        System.out.println( "----- INTERNAL ITERATOR with LAMBDA" );
        numbers.forEach(n -> System.out.println(n));

        System.out.println( "----- INTERNAL ITERATOR: WITH METHOD REFERENCE" );

        numbers.forEach(System.out::println);
    }
}
