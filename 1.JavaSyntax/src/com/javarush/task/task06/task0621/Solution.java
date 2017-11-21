package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat (grandFatherName);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat (grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat (fatherName,catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName,catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(catFather,sonName, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(catFather,daughterName, catMother);
        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentmother;
        private Cat parentfather;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentmother) {
            this.name = name;
            this.parentmother = parentmother;
        }
        Cat(Cat parentfather,String name) {
            this.name = name;
            this.parentfather = parentfather;
        }
        Cat(Cat parentfather,String name, Cat parentmother) {
            this.name = name;
            this.parentfather = parentfather;
            this.parentmother = parentmother;
        }

        @Override
        public String toString() {
            String s = "";
            if ((parentmother == null)&&(parentfather == null))
                s="Cat name is " + name + ", no mother"+ ", no father";
            else if((parentmother != null)&&(parentfather==null))
                s= "Cat name is " + name + ", mother is " + parentmother.name+", no father";
            else if ((parentmother==null)&&(parentfather!=null))
                s= "Cat name is " + name + ", no mother" + ", father is"+ parentfather.name;
            else if ((parentmother!=null)&&(parentfather!=null))
                s= "Cat name is " + name + ", mother is " + parentmother.name+", father is "+ parentfather.name;
        return s;
        }
    }
}

