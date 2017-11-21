package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
    TestThread.iscancel=false;
    }

    public static class TestThread implements Runnable {
        static boolean iscancel=true;
        public void run() {
            while (iscancel) {
                try {
                    Thread.sleep(500);
                    System.out.println("he-he");
                } catch (InterruptedException e) {
                }

            }
        }
    }
}
