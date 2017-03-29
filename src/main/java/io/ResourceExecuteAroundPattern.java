package io;

import java.util.function.Consumer;

public class ResourceExecuteAroundPattern {
    private ResourceExecuteAroundPattern() {
        System.out.println("Resource created...");
    }

    public ResourceExecuteAroundPattern op1() {
        System.out.println("op1");
        return this;
    }

    public ResourceExecuteAroundPattern op2() {
        System.out.println("op2");
        return this;
    }

    private void close() {
        System.out.println("cleanup of a very expensive resource... mixing program memory cleanup (GC) with other resource cleanup");
    }

    public static void use(Consumer<ResourceExecuteAroundPattern> resourceOperations) {
        ResourceExecuteAroundPattern resource = new ResourceExecuteAroundPattern();
        try {
            resourceOperations.accept(resource);

        } finally {
            resource.close();
        }
    }

    public static void main(String[] args) throws Throwable {

        ResourceExecuteAroundPattern.use(resource -> {
            resource.op1()
                    .op2();
        });

        System.out.println(">>> for this last option, we make close and constructor private");
        System.out.println(">>> then we create static function use");
        System.out.println(">>> we can also make the operations 'fluid'");

    }
}
