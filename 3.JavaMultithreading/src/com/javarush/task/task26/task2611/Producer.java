package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Daria Zhuravel
 * @date 08.03.18
 **/
public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        while (true){
            map.putIfAbsent(Integer.toString(i), "Some text for " + i);
            i++;
            try {
                Thread.currentThread().sleep(150);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "thread was terminated");
            }
        }
    }
}
