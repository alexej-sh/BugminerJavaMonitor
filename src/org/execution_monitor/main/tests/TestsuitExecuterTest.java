package org.execution_monitor.main.tests;

import org.execution_monitor.main.testexecution.TestsuitExecuter;
import org.execution_monitor.main.zuTestendeKlassen.HalloWelt;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by work on 24.11.2016.
 */
public class TestsuitExecuterTest {

    @Test
    public void main() throws Exception {
        String testClasses[] = {"org.execution_monitor.main.zuTestendeKlassen.HalloWeltTest", "org.execution_monitor.main.zuTestendeKlassen.HalloWelt"};

        TestsuitExecuter.main(testClasses);

    }

}