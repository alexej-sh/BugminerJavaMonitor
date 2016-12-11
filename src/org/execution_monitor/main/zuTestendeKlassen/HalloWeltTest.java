package org.execution_monitor.main.zuTestendeKlassen;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by work on 19.11.2016.
 */
public class HalloWeltTest {
    HalloWelt halloWelt = new HalloWelt();



    /*@org.junit.Test
    public void testPrintHalloWelt2() throws Exception {
        int i = 10;

        assertEquals(halloWelt.printHalloWelt(), "Hallo Welt2");

    }*/

    /*@org.junit.Test
    public void testThrowException() throws Exception {
        int i = 10;

        assertEquals(halloWelt.printException(), "Werfe Exception");
    }*/

    @Test
    public void testWPrintHalloWelt() throws Exception {
        int i = 10;
        System.out.println("Test1");

        assertEquals(halloWelt.printHalloWelt(), "Hallo Welt");

    }

    @Test
    public void testExceptionExample() throws Exception {
        int i = 10;
        System.out.println("Test2");

        assertTrue(halloWelt.exceptionExample());

    }

    @Test
    public void testReturn() {
        halloWelt.retTest();
    }


    private void foo() {

    }



}