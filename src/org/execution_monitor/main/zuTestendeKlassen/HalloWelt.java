package org.execution_monitor.main.zuTestendeKlassen;

/**
 * Created by work on 18.11.2016.
 */



public class HalloWelt {

    public String printHalloWelt() {
        String hallo = "Hallo";


        printArgument(hallo);
        printWelt();


        return "Hallo Welt";
    }

    private void printWelt() {
        System.out.println(" Welt");
    }




    private void printArgument(String hallo) {
        int i = 0;

        for (i = 0; i < 10; i++) {
            System.out.print("-");
        }
        System.out.println("");

        System.out.print(hallo);
    }

    public String printException() {
        int i = 0;

        if (10 == 10) {
            throw new IllegalArgumentException("HalloWeltException");
        }
        return "";
    }

    public boolean exceptionExample() {
        int i = 10;
        try {
            bar();
            int k = 10;
        } catch (InterruptedException e) {

        }
        return true;

    }

    private boolean foo() throws InterruptedException {
        int i = 10;
        if (i == 10) {
            throw new InterruptedException();
        }
        return false;
    }

    private void bar() throws InterruptedException {
        foo();
    }

    public void retTest() {
        return;
    }
}
