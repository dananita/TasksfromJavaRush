package com.javarush.task.task15.task1530;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 10.04.17.
 **/
public class TeaMaker extends DrinkMaker {
    @Override
    public void getRightCup() {
    System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }
}
