package com.javarush.task.task12.task1215;

/* 
Классы Cat и Dog от Pet
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        public String getName(){
            String s = "";
            return s;
        }
        public Cat getChild(){
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        public String getName(){
            String s = "";
            return s;
        }
        public Dog getChild(){
            return new Dog();
        }
    }

}
