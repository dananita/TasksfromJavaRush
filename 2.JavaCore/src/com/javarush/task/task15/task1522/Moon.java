package com.javarush.task.task15.task1522;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 09.04.17.
 **/
public class Moon implements Planet{
    private static Moon instance;
    private Moon(){}

    public static Moon getInsance(){
        if (instance==null){
            instance = new Moon();
        }
        return instance;
    }
}
