package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int count1 = this.strength*3+this.age*2+this.weight;
        int count2 = anotherCat.strength*3+anotherCat.age*2+anotherCat.weight;
        if (count1 >=count2){
            return true;
        }
        else { return false;}

    }

    public static void main(String[] args) {
    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    cat1.name = "Lis";
    cat2.name = "Mas";
    cat1.weight = 2;
    cat2.weight = 4;
    cat1.age = 3;
    cat2.age = 3;
    cat1.strength = 5;
    cat2.strength = 6;

        System.out.println(cat1.fight(cat2));
        if ((cat1.fight(cat2)==true)&&(cat2.fight(cat1)==true)){
            System.out.println(false);
        }
        else {
        System.out.println(cat2.fight(cat1));}
    }
}
