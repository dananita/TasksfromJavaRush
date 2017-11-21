package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private String addessess;
        private float weightkg;
        private double weightgostatok;

        public Human(String name){
            this.name = name;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }
        public Human(String name, int age, boolean sex,float weightkg,double weightgostatok){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weightkg = weightkg;
            this.weightgostatok = weightgostatok;
        }
        public Human(String name, int age, boolean sex,float weightkg){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weightkg = weightkg;
            this.weightgostatok = 0;
        }
        public Human(String name, int age, boolean sex,float weightkg,String addessess,double weightgostatok){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weightkg = weightkg;
            this.weightgostatok = weightgostatok;
            this.addessess = addessess;
        }
        public Human(int age, boolean sex,float weightkg, double weightgostatok){
            this.age = age;
            this.sex = sex;
            this.weightkg = weightkg;
            this.weightgostatok = weightgostatok;
        }
        public Human(int age, boolean sex,float weightkg){
            this.age = age;
            this.sex = sex;
            this.weightkg = weightkg;
        }
        public Human(String name, boolean sex,String addessess){
            this.name = name;
            this.sex = sex;
            this.addessess = addessess;
        }
       /* public Human(float weightkg, double weightgostatok){
            this.weightkg = weightkg;
            this.weightgostatok = weightgostatok;
        }*/

    }
}
