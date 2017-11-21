package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println(" new");

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> result = new HashSet<Dog>();
        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet result = new HashSet()      ;
        for (int i = 0; i <cats.toArray().length; i++) {
            result.add(cats.toArray()[i]);
        }
        for (int j = 0; j <dogs.toArray().length ; j++) {
            result.add(dogs.toArray()[j]);
        }
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for (int i = 0; i <cats.size() ; i++) {
            if (pets.contains(cats.toArray()[i])) {
                pets.remove(cats.toArray()[i]);
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (int i = 0; i <pets.toArray().length ; i++) {
            System.out.println(pets.toArray()[i]);
        }
    }
    public static class Cat{
        Set cats;
    }

    public  static class Dog{
        Set dogs;
    }
    //напишите тут ваш код
}
