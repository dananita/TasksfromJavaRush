package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String color;
    String address;

    public void initialize(String name){
        this.name = name;
        this.weight = 1;
        this.age = 1;
        this.color = "white";
        this.address = null;
    }
    public void initialize(String name,int age, int weight){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "white";
        this.address = null;
    }
    public void initialize(String color, int weight){
        this.name = null;
        this.weight = weight;
        this.age = 1;
        this.color = color;
        this.address = null;
    }
    public void initialize(String color, int weight, String address){
        this.name = null;
        this.weight = weight;
        this.age = 1;
        this.color = color;
        this.address = address;
    }


    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
