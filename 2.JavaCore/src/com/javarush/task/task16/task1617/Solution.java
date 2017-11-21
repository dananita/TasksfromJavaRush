package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (!currentThread().isInterrupted()) {
                    int timecount=0;
                    System.out.println(countSeconds);
                    countSeconds--;
                    timecount++;
                    Thread.sleep(1000);
                    /*if (timecount>=3.5){
                        System.out.println("Прервано!"); break;
                    }*/
                    if (countSeconds == 0) {
                        System.out.println("Марш!");
                        break;
                    }
                }
            } catch(InterruptedException e){
                System.out.println("Прервано!");
            }
        }
    }
}
