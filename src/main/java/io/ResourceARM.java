package io;

public class ResourceARM implements AutoCloseable {

    public ResourceARM() {
        System.out.println("Resource created...");
    }

    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    @Override
    public void close() {
        System.out.println("cleanup of a very expensive resource... mixing program memory cleanup (GC) with other resource cleanup");
    }

    public static void main(String[] args) throws Throwable {


        try (ResourceARM resource = new ResourceARM()) {
            resource.op1();
            resource.op2();
        }

        System.out.println(">>> this code is working, and now; close is always called");
        System.out.println(">>> but we can still forget about putting resource inside an ARM try");

    }
}
