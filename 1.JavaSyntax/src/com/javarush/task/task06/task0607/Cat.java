package com.javarush.task.task06.task0607;

/* 
Классовый счетчик
*/


public class Cat {
    private static int catCount=0;
    public Cat(){
        Cat.catCount++;
    }
    //напишите тут ваш код

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println(catCount);
    }

}
