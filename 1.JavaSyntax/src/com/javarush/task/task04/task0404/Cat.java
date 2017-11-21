package com.javarush.task.task04.task0404;

/* 
Реализовать метод addNewCat
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        Cat.catsCount = Cat.catsCount +1;
        System.out.println(Cat.catsCount);
    }

    public static void main(String[] args) {
    Cat cat1 = new Cat();
    cat1.addNewCat();
    Cat cat2 = new Cat();
    cat2.addNewCat();
    }
}
