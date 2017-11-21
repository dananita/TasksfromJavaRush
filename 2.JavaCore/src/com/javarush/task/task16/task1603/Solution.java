package com.javarush.task.task16.task1603;

import
        java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        /*SpecialThread s = new SpecialThread();
        Thread ss = new Thread(s);
        ss.start();
        SpecialThread s1 = new SpecialThread();
        Thread ss1 = new Thread(s1);
        ss1.start();
        SpecialThread s2 = new SpecialThread();
        Thread ss2 = new Thread(s2);
        ss2.start();
        SpecialThread s3 = new SpecialThread();
        Thread ss3 = new Thread(s3);
        ss3.start();
        SpecialThread s4 = new SpecialThread();
        Thread ss4 = new Thread(s4);
        ss4.start();
*/
        for (int i = 0; i <5 ; i++) {
            /*Thread m= new Thread(new SpecialThread());
            m.start();*/
            list.add(new Thread(new SpecialThread()));
         //   System.out.println(list.get(i));
        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
