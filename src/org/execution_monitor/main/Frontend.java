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


public class Frontend {

    public static void main(String[] argv) {
        /**
         * Classpath für: Bugminer, JUnit und zu testende Anwendung
         */
        //Das sind die Einstellungen für Testfälle aus diesem Projekt z.B. für HalloWeltTest

        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar";

        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);

        String projectPackageName = "org.execution_monitor.main.";

        Class<?>[] testclasses = new Class[1];
        testclasses[0] = HalloWeltTest.class;
        //testclasses[1] = TestsuitExecuterTest.class;


        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath,
                                blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();


        /**
         * Einstellungen fuer externe Testfaelle
         */

        /*
        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\out\\production\\TestanwendungFuerBugminer";

        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);


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

        /*
        String classpath = "E:\\Projects\\Java\\Bugminer\\Prototyp3\\out\\production\\Prototyp2;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\junit-4.12.jar;" +
                "E:\\Projects\\Java\\Bugminer\\libs\\hamcrest-core-1.3.jar;" +
                "E:\\Tools\\m2\\javax\\servlet\\javax.servlet-api\\3.1.0\\javax.servlet-api-3.1.0.jar;E:\\Tools\\m2\\javax\\ws\\rs\\javax.ws.rs-api\\2.0.1\\javax.ws.rs-api-2.0.1.jar;E:\\Tools\\m2\\org\\apache\\cxf\\cxf-rt-transports-http\\3.1.2\\cxf-rt-transports-http-3.1.2.jar;E:\\Tools\\m2\\org\\apache\\cxf\\cxf-core\\3.1.2\\cxf-core-3.1.2.jar;E:\\Tools\\m2\\org\\codehaus\\woodstox\\woodstox-core-asl\\4.4.1\\woodstox-core-asl-4.4.1.jar;E:\\Tools\\m2\\org\\codehaus\\woodstox\\stax2-api\\3.1.4\\stax2-api-3.1.4.jar;E:\\Tools\\m2\\org\\apache\\ws\\xmlschema\\xmlschema-core\\2.2.1\\xmlschema-core-2.2.1.jar;E:\\Tools\\m2\\org\\apache\\cxf\\cxf-rt-frontend-jaxrs\\3.1.2\\cxf-rt-frontend-jaxrs-3.1.2.jar;E:\\Tools\\m2\\javax\\annotation\\javax.annotation-api\\1.2\\javax.annotation-api-1.2.jar;E:\\Tools\\m2\\org\\springframework\\spring-websocket\\4.2.5.RELEASE\\spring-websocket-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-context\\4.2.5.RELEASE\\spring-context-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-aop\\4.2.5.RELEASE\\spring-aop-4.2.5.RELEASE.jar;E:\\Tools\\m2\\aopalliance\\aopalliance\\1.0\\aopalliance-1.0.jar;E:\\Tools\\m2\\org\\springframework\\spring-core\\4.2.5.RELEASE\\spring-core-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-web\\4.2.5.RELEASE\\spring-web-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-webmvc\\4.2.5.RELEASE\\spring-webmvc-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-beans\\4.2.5.RELEASE\\spring-beans-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\spring-expression\\4.2.5.RELEASE\\spring-expression-4.2.5.RELEASE.jar;E:\\Tools\\m2\\io\\springfox\\springfox-spring-web\\2.5.0\\springfox-spring-web-2.5.0.jar;E:\\Tools\\m2\\com\\google\\guava\\guava\\18.0\\guava-18.0.jar;E:\\Tools\\m2\\com\\fasterxml\\classmate\\1.3.1\\classmate-1.3.1.jar;E:\\Tools\\m2\\org\\slf4j\\slf4j-api\\1.7.21\\slf4j-api-1.7.21.jar;E:\\Tools\\m2\\org\\springframework\\plugin\\spring-plugin-core\\1.2.0.RELEASE\\spring-plugin-core-1.2.0.RELEASE.jar;E:\\Tools\\m2\\org\\springframework\\plugin\\spring-plugin-metadata\\1.2.0.RELEASE\\spring-plugin-metadata-1.2.0.RELEASE.jar;E:\\Tools\\m2\\io\\springfox\\springfox-spi\\2.5.0\\springfox-spi-2.5.0.jar;E:\\Tools\\m2\\io\\springfox\\springfox-core\\2.5.0\\springfox-core-2.5.0.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-server\\8.1.8.v20121106\\jetty-server-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\orbit\\javax.servlet\\3.0.0.v201112011016\\javax.servlet-3.0.0.v201112011016.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-continuation\\8.1.8.v20121106\\jetty-continuation-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-http\\8.1.8.v20121106\\jetty-http-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-io\\8.1.8.v20121106\\jetty-io-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-webapp\\8.1.8.v20121106\\jetty-webapp-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-xml\\8.1.8.v20121106\\jetty-xml-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-util\\8.1.8.v20121106\\jetty-util-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-servlet\\8.1.8.v20121106\\jetty-servlet-8.1.8.v20121106.jar;E:\\Tools\\m2\\org\\eclipse\\jetty\\jetty-security\\8.1.8.v20121106\\jetty-security-8.1.8.v20121106.jar;E:\\Tools\\m2\\junit\\junit\\4.11\\junit-4.11.jar;E:\\Tools\\m2\\org\\hamcrest\\hamcrest-core\\1.3\\hamcrest-core-1.3.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\core\\jackson-databind\\2.7.3\\jackson-databind-2.7.3.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\core\\jackson-annotations\\2.7.0\\jackson-annotations-2.7.0.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\core\\jackson-core\\2.7.3\\jackson-core-2.7.3.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\module\\jackson-module-afterburner\\2.7.3\\jackson-module-afterburner-2.7.3.jar;E:\\Tools\\m2\\cglib\\cglib-nodep\\2.2.2\\cglib-nodep-2.2.2.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\jaxrs\\jackson-jaxrs-json-provider\\2.7.3\\jackson-jaxrs-json-provider-2.7.3.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\jaxrs\\jackson-jaxrs-base\\2.7.3\\jackson-jaxrs-base-2.7.3.jar;E:\\Tools\\m2\\com\\fasterxml\\jackson\\module\\jackson-module-jaxb-annotations\\2.7.3\\jackson-module-jaxb-annotations-2.7.3.jar;E:\\Tools\\m2\\com\\googlecode\\json-simple\\json-simple\\1.1.1\\json-simple-1.1.1.jar;E:\\Tools\\m2\\commons-io\\commons-io\\1.4\\commons-io-1.4.jar;E:\\Tools\\m2\\net\\sf\\json-lib\\json-lib\\2.4\\json-lib-2.4-jdk15.jar;E:\\Tools\\m2\\commons-beanutils\\commons-beanutils\\1.8.0\\commons-beanutils-1.8.0.jar;E:\\Tools\\m2\\commons-collections\\commons-collections\\3.2.1\\commons-collections-3.2.1.jar;E:\\Tools\\m2\\commons-lang\\commons-lang\\2.5\\commons-lang-2.5.jar;E:\\Tools\\m2\\commons-logging\\commons-logging\\1.1.1\\commons-logging-1.1.1.jar;E:\\Tools\\m2\\net\\sf\\ezmorph\\ezmorph\\1.0.6\\ezmorph-1.0.6.jar;E:\\Tools\\m2\\com\\google\\code\\gson\\gson\\2.6.2\\gson-2.6.2.jar;E:\\Tools\\m2\\net\\minidev\\json-smart\\2.2.1\\json-smart-2.2.1.jar;E:\\Tools\\m2\\net\\minidev\\accessors-smart\\1.1\\accessors-smart-1.1.jar;E:\\Tools\\m2\\com\\owlike\\genson\\1.4\\genson-1.4.jar;E:\\Tools\\m2\\com\\owlike\\genson-scala_2.11\\1.4\\genson-scala_2.11-1.4.jar;E:\\Tools\\m2\\org\\scala-lang\\scala-reflect\\2.11.0\\scala-reflect-2.11.0.jar;E:\\Tools\\m2\\org\\scala-lang\\scala-library\\2.11.0\\scala-library-2.11.0.jar;E:\\Tools\\m2\\org\\clojure\\clojure\\1.5.1\\clojure-1.5.1.jar;E:\\Tools\\m2\\org\\codehaus\\groovy\\groovy\\2.1.5\\groovy-2.1.5.jar;E:\\Tools\\m2\\antlr\\antlr\\2.7.7\\antlr-2.7.7.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm-tree\\4.0\\asm-tree-4.0.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm-commons\\4.0\\asm-commons-4.0.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm\\4.0\\asm-4.0.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm-util\\4.0\\asm-util-4.0.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm-analysis\\4.0\\asm-analysis-4.0.jar;E:\\Tools\\m2\\org\\springframework\\spring-test\\4.2.5.RELEASE\\spring-test-4.2.5.RELEASE.jar;E:\\Tools\\m2\\org\\javassist\\javassist\\3.18.0-GA\\javassist-3.18.0-GA.jar;E:\\Tools\\m2\\org\\apache\\cxf\\cxf-rt-rs-client\\3.1.2\\cxf-rt-rs-client-3.1.2.jar;E:\\Tools\\m2\\com\\squareup\\okhttp3\\okhttp\\3.2.0\\okhttp-3.2.0.jar;E:\\Tools\\m2\\com\\squareup\\okio\\okio\\1.6.0\\okio-1.6.0.jar;E:\\Tools\\m2\\org\\springframework\\data\\spring-data-commons-core\\1.4.1.RELEASE\\spring-data-commons-core-1.4.1.RELEASE.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\containers\\jersey-container-servlet\\2.21\\jersey-container-servlet-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\containers\\jersey-container-servlet-core\\2.21\\jersey-container-servlet-core-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\core\\jersey-common\\2.21\\jersey-common-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\bundles\\repackaged\\jersey-guava\\2.21\\jersey-guava-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\osgi-resource-locator\\1.0.1\\osgi-resource-locator-1.0.1.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\core\\jersey-server\\2.21\\jersey-server-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\media\\jersey-media-jaxb\\2.21\\jersey-media-jaxb-2.21.jar;E:\\Tools\\m2\\javax\\validation\\validation-api\\1.1.0.Final\\validation-api-1.1.0.Final.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\core\\jersey-client\\2.21\\jersey-client-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\hk2-api\\2.4.0-b31\\hk2-api-2.4.0-b31.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\hk2-utils\\2.4.0-b31\\hk2-utils-2.4.0-b31.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\external\\aopalliance-repackaged\\2.4.0-b31\\aopalliance-repackaged-2.4.0-b31.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\external\\javax.inject\\2.4.0-b31\\javax.inject-2.4.0-b31.jar;E:\\Tools\\m2\\org\\glassfish\\hk2\\hk2-locator\\2.4.0-b31\\hk2-locator-2.4.0-b31.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\test-framework\\providers\\jersey-test-framework-provider-jdk-http\\2.21\\jersey-test-framework-provider-jdk-http-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\test-framework\\jersey-test-framework-core\\2.21\\jersey-test-framework-core-2.21.jar;E:\\Tools\\m2\\org\\glassfish\\jersey\\containers\\jersey-container-jdk-http\\2.21\\jersey-container-jdk-http-2.21.jar;E:\\Tools\\m2\\org\\ow2\\asm\\asm-debug-all\\5.0.4\\asm-debug-all-5.0.4.jar;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\fastjson-master\\target\\test-classes;" +
                "E:\\Projects\\Java\\TestanwendungFuerBugminer\\fastjson-master\\target\\classes";

        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);


        String projectPackageName = "com.alibaba.fastjson.";//Whitelist

        String[] testclasses = new String[1];
        testclasses[0] = "com.alibaba.fastjson.serializer.TestParse";//TestsuitExecuterTest zeigt wie man Klassen als Strings angeben soll
        //testclasses[1] = TestsuitExecuterTest.class;


        ExecutionMonitor executionMonitor = new ExecutionMonitor(classpath,
                blockingQueue, projectPackageName, testclasses);

        executionMonitor.startMonitoring();
*/
    }


}


