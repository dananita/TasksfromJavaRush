package com.javarush.task.task08.task0814;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet set = new HashSet();
        for (int i = 0; i <20 ; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        ArrayList<Integer>list = new ArrayList<>();
        list.addAll(set);
        for (int i=0;i<list.size();i++) {
            if (list.get(i)>10){
                list.remove(i);
                i--;
            }
        }
        set.clear();
        set.addAll(list);

        return set;
    }

    public static void main(String[] args) {
   /* HashSet s = createSet();
    s = removeAllNumbersMoreThan10(s);
        System.out.println(s);*/
    }
}
