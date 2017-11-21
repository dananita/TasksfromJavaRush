package com.javarush.task.task08.task0813;

import java.util.Collections;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static HashSet<String> createSet() {
        //напишите тут ваш код
        HashSet set = new HashSet();
        Collections.addAll(set,"Люба","Люк","Лимфа","Люстра","Лик","Лыко","Ломоть","Лассо","Лоток","Лоб","Лось","Лампа","Лямка","Любой","Лобок","Ларек","Лак","Ласточка","Лада","Леска");
        return set;
    }

    public static void main(String[] args) {

    }
}
