package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listby3= new ArrayList<>();
        ArrayList<Integer> listby2= new ArrayList<>();
        ArrayList<Integer> listbyother= new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            list.add(Integer.parseInt(reader.readLine()));
                if ((list.get(i)%3)==0){
                    listby3.add(list.get(i));
                }
                if ((list.get(i) % 2) == 0) {
                        listby2.add(list.get(i));
                }
                if ((((list.get(i)%3)!=0)&&(list.get(i)%2)!=0)){
                    listbyother.add(list.get(i));
                }
        }
        printList(listby3);
        printList(listby2);
        printList(listbyother);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
