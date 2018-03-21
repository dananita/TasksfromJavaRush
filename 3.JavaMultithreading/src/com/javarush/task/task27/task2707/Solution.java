package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread firstThread = new Thread(){
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread secondThread = new Thread(){
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1,o2);
            }
        };
        firstThread.start();
        Thread.sleep(10);
        secondThread.start();
        Thread.sleep(10);
        synchronized (o2){
            return secondThread.getState().equals(Thread.State.BLOCKED);
        }
        //do something here
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
