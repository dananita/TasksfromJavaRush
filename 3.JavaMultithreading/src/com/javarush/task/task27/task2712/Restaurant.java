package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

/**
 * @author Daria Zhuravel
 * @date 03.04.18
 **/
public class Restaurant {
    public static void main(String[] args){
        Tablet tablet = new Tablet(5);
        tablet.createOrder();
        Cook cook = new Cook("Misha");
        tablet.addObserver(cook);
    }
}
