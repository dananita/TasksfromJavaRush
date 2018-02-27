package com.javarush.task.task25.task2506;

import static java.lang.Thread.State.TERMINATED;

/*
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(1000);
        target.start();  //RUNNABLE
        Thread.sleep(1000);
        //TERMINATED
    }

}
