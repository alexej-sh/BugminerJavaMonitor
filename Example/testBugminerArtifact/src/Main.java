import org.execution_monitor.main.monitoring.ExecutionMonitor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\JavaExecutionMonitorPrototyp3.jar;" + //Pfad zu dem JavaExecutionMonitor

                //alle Pfade, die Maven mit "mvn dependency:build-classpath -Dmdep.outputFile=cp.txt" rausgibt
                "E:\\Tools\\m2\\junit\\junit\\4.12\\junit-4.12.jar;E:\\Tools\\m2\\org\\hamcrest\\hamcrest-core\\1.3\\hamcrest-core-1.3.jar;E:\\Tools\\m2\\org\\hamcrest\\hamcrest-all\\1.3\\hamcrest-all-1.3.jar;E:\\Tools\\m2\\commons-io\\commons-io\\2.5\\commons-io-2.5.jar;E:\\Tools\\m2\\org\\apache\\bcel\\bcel\\6.0\\bcel-6.0.jar;E:\\Tools\\m2\\org\\easymock\\easymock\\3.4\\easymock-3.4.jar;E:\\Tools\\m2\\org\\objenesis\\objenesis\\2.2\\objenesis-2.2.jar;" +

                //Pfad zu den .class Files der Testklassen
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\commons-lang-master\\target\\test-classes;" +

                //Pfad zu den .class Files der eigentlichen Klassen des Testprojekts
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\commons-lang-master\\target\\classes";

        BlockingQueue blockingQueue = new LinkedBlockingQueue(20000);

        //Whitelist, durch diese Angabe können wir zwischen Klassen aus dem Testprojekt und restlichen KLassen unterscheiden
        String projectPackageName = "org.apache.commons.lang3.";

        String[] testclasses = new String[1];
        //Namen der Testklassen müssen vollqualifiziert sein d.h. mit Packageangabe
        testclasses[0] = "org.apache.commons.lang3.AnnotationUtilsTest";

        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath, blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();

    }
}
