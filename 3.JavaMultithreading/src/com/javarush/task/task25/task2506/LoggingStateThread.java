package com.javarush.task.task25.task2506;

import static java.lang.Thread.State.TERMINATED;

/**
 * @author Daria Zhuravel
 * @author (zlakdanata@yandex.ru)
 * @date 27.02.18
 **/
public class LoggingStateThread extends Thread{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State state = State.NEW;
        System.out.println(thread.getState());
        while (true) {
            if (state != thread.getState()) {
                System.out.println(thread.getState());
                state = thread.getState();
            }
            if(state == TERMINATED){
                break;
            }
        }
    }
}
