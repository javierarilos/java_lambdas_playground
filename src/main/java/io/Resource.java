package io;

public class Resource {
    public Resource() {
        System.out.println("Resource created...");
    }

    public void op1(){
        System.out.println("op1");
    }

    public void op2(){
        System.out.println("op2");
    }

    protected void close() throws Throwable {
        System.out.println("cleanup of a very expensive resource... mixing program memory cleanup (GC) with other resource cleanup");
    }

    public static void main(String[] args) throws Throwable {

        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        resource.close();

        System.out.println(">>> this code is working, but has two problems:");
        System.out.println(">>> first, it is easy to forget close");
        System.out.println(">>> second, if an exception is thrown, close is never called");

    }
}
