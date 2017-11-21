package com.javarush.task.task15.task1530;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 10.04.17.
 **/
public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();
    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
