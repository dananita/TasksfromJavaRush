package com.javarush.task.task15.task1522;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 09.04.17.
 **/
public class Sun implements Planet{
    private static Sun instance;
    private Sun(){}

    public static Sun getInsance(){
        if (instance==null){
            instance = new Sun();
        }
        return instance;
    }
}
