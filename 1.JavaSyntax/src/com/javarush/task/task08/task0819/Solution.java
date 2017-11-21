package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator itr = cats.iterator();
        cats.remove(cats.iterator().next());
        //removeCats(cats);
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }


    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set cats = new HashSet();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        //printCats(cats);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (int i = 0; i <cats.toArray().length ; i++) {
            System.out.println(cats.toArray()[i]);
        }

    }
    /*public static void  removeCats (Set<Objects> pets, Set<Cat> cats){
        for (Cat x:cats) {
            pets.remove(cats);
        }
    }*/
    public static class Cat{
        Set cats;

    }// step 1 - пункт 1

}
