package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList <String> list = new ArrayList<>();
        while( e != null){
            list.add(e.toString());
            e = e.getCause();
        }

        Collections.reverse(list);

        for (String l: list) {
            System.out.println(l);
        }
        /*System.out.println(e.getCause().getCause());
        System.out.println(e.getCause());
        System.out.println(e.toString());*/
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        solution.uncaughtException(Thread.currentThread(),
         new Exception("ABC",
                new RuntimeException("DEF",
                        new IllegalAccessException("GHI"))));
    }
}
