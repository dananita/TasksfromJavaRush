package com.javarush.task.task15.task1522;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 09.04.17.
 **/
public class Earth implements Planet{
    private static Earth instance;
    private Earth(){}

    public static Earth getInsance(){
        if (instance==null){
            instance = new Earth();
        }
        return instance;
    }
}
