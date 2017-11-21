package com.javarush.task.task14.task1421;

/**
 * Alex Tingaev (tingaev@gmail.com) on 02.04.17.
 **/
public class Singleton {
    static private boolean flag = true;
    static private Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){
    }
}
