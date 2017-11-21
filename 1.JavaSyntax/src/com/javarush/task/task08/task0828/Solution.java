package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String nameMonth=reader.readLine();
        Character n=nameMonth.charAt(0);
        nameMonth = nameMonth.replace(n,Character.toUpperCase(n));
        ArrayList listMonth = new ArrayList();
        listMonth.add("January");
        listMonth.add("February");
        listMonth.add("March");
        listMonth.add("April");
        listMonth.add("May");
        listMonth.add("June");
        listMonth.add("July");
        listMonth.add("August");
        listMonth.add("September");
        listMonth.add("October");
        listMonth.add("November");
        listMonth.add("December");
        //System.out.println(listMonth);
        for (int i = 0; i <listMonth.size() ; i++) {
            if (nameMonth.contains((String)listMonth.get(i))){
                System.out.println(nameMonth+" is "+(i+1)+" month");
                break;
            }
        }
    }
}
