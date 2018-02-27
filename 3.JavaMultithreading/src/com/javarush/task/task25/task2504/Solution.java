package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (int i = 0; i < threads.length ; i++) {
            //System.out.println(threads[i].getState());
            switch (threads[i].getState()){
                case NEW : {
                    threads[i].start();
                    break;
                }
                case RUNNABLE:{
                    threads[i].isInterrupted();
                    break;
                }
                case WAITING:case BLOCKED:case TIMED_WAITING:{
                    threads[i].interrupt();
                    break;
                }
                case TERMINATED:{
                    System.out.println(threads[i].getPriority());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads = new Thread[4];
        for (int i = 0; i < threads.length ; i++) {
            threads[i] = new Thread(Integer.toString(i));
//            System.out.println("treads = "+threads[i]);
        }
        threads[1].start();
        threads[1].sleep(3000);
        threads[2].start();
        threads[2].interrupt();
        threads[3].start();
        processThreads(threads);
    }
}
