package com.javarush.task.task15.task1530;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Daria Zhuravel (zlakdanata@yandex.ru) on 10.04.17.
 **/
public class LatteMaker extends DrinkMaker {
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    public void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем молоко с пенкой");

    }
}
