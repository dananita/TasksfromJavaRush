package com.javarush.task.task29.task2912;

/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public abstract class AbstractLogger implements Logger{
    int level;
    Logger next;

    public AbstractLogger(int level) {
        this.level = level;
    }

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }

    public abstract void info(String message);
}
