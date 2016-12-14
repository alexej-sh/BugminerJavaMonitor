package org.execution_monitor.main;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.*;
import com.sun.jdi.request.EventRequestManager;
import com.sun.jdi.request.MethodEntryRequest;
import com.sun.jdi.request.MethodExitRequest;
import com.sun.jdi.request.StepRequest;
import org.execution_monitor.main.monitoring.ExecutionMonitor;
import org.execution_monitor.main.monitoring.JVMConnectionCreator;
import org.execution_monitor.main.tests.TestsuitExecuterTest;
import org.execution_monitor.main.zuTestendeKlassen.HalloWeltTest;


import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Frontend {

    public static void main(String[] argv) {
        /**
         * Classpath für: Bugminer, JUnit und zu testende Anwendung
         */
        //Das sind die Einstellungen für Testfälle aus diesem Projekt z.B. für HalloWeltTest
/*
        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar";

        BlockingQueue blockingQueue = new LinkedBlockingQueue(1024);

        String projectPackageName = "org.execution_monitor.main.";

        Class<?>[] testclasses = new Class[1];
        testclasses[0] = HalloWeltTest.class;
        //testclasses[1] = TestsuitExecuterTest.class;


        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath,
                                blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();
*/

        /**
         * Einstellungen fuer externe Testfaelle
         */

        /*
        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\out\\production\\TestanwendungFuerBugminer";

        BlockingQueue blockingQueue = new LinkedBlockingQueue(1024);


        String projectPackageName = "my.customPackage.";//Whitelist

        String[] testclasses = new String[1];
        testclasses[0] = "my.customPackage.MainTest";//TestsuitExecuterTest zeigt wie man Klassen als Strings angeben soll
        //testclasses[1] = TestsuitExecuterTest.class;


        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath,
                blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();
        */

        /**
         * Einstellungen für einen großen Projekt
         */

        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar;" +
                "E:\\Tools\\m2\\junit\\junit\\4.12\\junit-4.12.jar;E:\\Tools\\m2\\org\\hamcrest\\hamcrest-core\\1.3\\hamcrest-core-1.3.jar;E:\\Tools\\m2\\org\\hamcrest\\hamcrest-all\\1.3\\hamcrest-all-1.3.jar;E:\\Tools\\m2\\commons-io\\commons-io\\2.5\\commons-io-2.5.jar;E:\\Tools\\m2\\org\\apache\\bcel\\bcel\\6.0\\bcel-6.0.jar;E:\\Tools\\m2\\org\\easymock\\easymock\\3.4\\easymock-3.4.jar;E:\\Tools\\m2\\org\\objenesis\\objenesis\\2.2\\objenesis-2.2.jar;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\commons-lang-master\\target\\test-classes;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\commons-lang-master\\target\\classes";

        BlockingQueue blockingQueue = new LinkedBlockingQueue(20000);


        String projectPackageName = "org.apache.commons.lang3.";//Whitelist

        String[] testclasses = new String[1];
        testclasses[0] = "org.apache.commons.lang3.AnnotationUtilsTest";//TestsuitExecuterTest zeigt wie man Klassen als Strings angeben soll
        //testclasses[1] = TestsuitExecuterTest.class;


        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath,
                blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();

    }


}


