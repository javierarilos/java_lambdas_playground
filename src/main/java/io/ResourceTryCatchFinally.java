package io;

public class ResourceTryCatchFinally {

        public ResourceTryCatchFinally() {
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

            ResourceTryCatchFinally resource = new ResourceTryCatchFinally();
            try {
                resource.op1();
                resource.op2();
            } finally {
                resource.close();
            }

            System.out.println(">>> this code is working, and now; close is always called");
            System.out.println(">>> first, it is even easier to forget close and try/finally");

        }
    }
