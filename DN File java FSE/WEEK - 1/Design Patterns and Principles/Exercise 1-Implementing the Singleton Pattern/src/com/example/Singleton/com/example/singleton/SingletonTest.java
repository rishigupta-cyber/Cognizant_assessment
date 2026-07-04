package com.example.singleton;

// simple test class to check whether the Singleton pattern is actually working
public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("---- Getting first Logger object ----");
        Logger logger1 = Logger.getInstance();
        logger1.log("App started");

        System.out.println("\n---- Getting second Logger object ----");
        Logger logger2 = Logger.getInstance();
        logger2.log("Second call to logger");

        System.out.println("\n---- Checking if both are same instance ----");
        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Success! Both references point to the same Logger object.");
        } else {
            System.out.println("Something is wrong, two different objects were created.");
        }

        // logCount is shared between logger1 and logger2 since they are the same object
        System.out.println("\nTotal logs made so far: " + logger1.getLogCount());

        logger1.log("One more log to confirm shared state");
        System.out.println("Now logger2 also shows updated count: " + logger2.getLogCount());
    }
}