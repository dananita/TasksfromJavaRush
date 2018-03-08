package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        while (true) {
            try {
                if (!lock.tryLock()){
                    ifLockIsBusy();
                } else {
                    ifLockIsFree();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.tryLock())
                    lock.unlock();
                break;
            }
        }
    }

    public void ifLockIsFree() {
        lock.lock();
    }

    public void ifLockIsBusy() throws InterruptedException {
        Thread.currentThread().sleep(100);
    }
}
