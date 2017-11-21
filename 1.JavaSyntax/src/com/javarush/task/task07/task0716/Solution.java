package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        for (int i=0;i<list.size();i++) {
            String s = list.get(i);
            if ((s.indexOf("р") != -1) && (s.indexOf("л") != -1)) {
            } else {
                if (s.indexOf("р") >= 0) {
                    list.remove(i);
                    i--;
                }
            }
        }
        for (int i=0;i<list.size();i++) {
            String s = list.get(i);
            if ((s.indexOf("р") != -1) && (s.indexOf("л") != -1)) {
            } else {
                if (s.indexOf("л") >= 0) {
                    //System.out.println("l "+s.indexOf("л"));
                    //if (list.get(i).intern()==list.get(i-1).intern()){
                    list.add(i,list.get(i));
                    i++;
                }
            }
        }
        return list;
    }
}