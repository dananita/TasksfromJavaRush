package com.javarush.task.task06.task0614;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Статические коты
*/

public class Cat {

    public static  ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    cats.add(this);
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i <10 ; i++) {
            Cat cat = new Cat();
        }
        printCats();
    }

    public static void printCats() {
        for (int i = 0; i <Cat.cats.size(); i++) {
            System.out.println(Cat.cats.get(i));
        }
    }
}
