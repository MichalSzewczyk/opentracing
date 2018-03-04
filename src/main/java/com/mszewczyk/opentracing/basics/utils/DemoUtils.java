package com.mszewczyk.opentracing.basics.utils;

public class DemoUtils {
    public static void executeLongRunningTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeShortRunningTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
