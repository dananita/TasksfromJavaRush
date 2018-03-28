package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Daria Zhuravel
 * @date 28.03.18
 **/
public class MyThread extends Thread{
    private static AtomicInteger priority = new AtomicInteger(1);
    public MyThread() {
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }

    }

    public MyThread(String name) {
        super(name);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (priority.get() < 10){
            setPriority(priority.getAndIncrement());
        } else {
            setPriority(priority.get());
            priority.set(MIN_PRIORITY);
        }
    }
}
