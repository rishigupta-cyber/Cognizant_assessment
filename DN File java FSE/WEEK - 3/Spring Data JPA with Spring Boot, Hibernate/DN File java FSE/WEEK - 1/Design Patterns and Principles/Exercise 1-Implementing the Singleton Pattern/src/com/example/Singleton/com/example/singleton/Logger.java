package com.example.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

// Logger class following the Singleton design pattern.
// The idea is simple - only one Logger object should exist in the whole app,
// so every class that logs something uses the same instance.
public class Logger {

    // this holds the one and only instance of Logger
    // volatile so that changes are visible to all threads immediately
    private static volatile Logger instance;

    // just to keep track of how many times log() has been called
    private int logCount;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // constructor is private -> nobody outside this class can do "new Logger()"
    private Logger() {
        System.out.println("Logger instance created -> " + this.hashCode());
    }

    // this is the only way to get a Logger object
    // using double checked locking so it stays thread safe but also fast
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        String time = dateFormat.format(new Date());
        System.out.println("[" + time + "] Log #" + logCount + " -> " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}