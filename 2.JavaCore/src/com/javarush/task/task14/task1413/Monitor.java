package com.javarush.task.task14.task1413;

/**
 * Alex Tingaev (tingaev@gmail.com) on 02.04.17.
 **/
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
