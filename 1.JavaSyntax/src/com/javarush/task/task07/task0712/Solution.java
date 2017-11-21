package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int weightsmall=127,weightbig=0;
        for (int i = 0; i <10 ; i++) {
            list.add(reader.readLine());
            if (weightbig<list.get(i).length()){
                weightbig=list.get(i).length();
            }
            if (weightsmall>list.get(i).length()){
                weightsmall=list.get(i).length();
            }
        }
        boolean s=true,b=true,sb=true;
        for (int i = 0; i <list.size() ; i++) {
            if ((s==true)&&(list.get(i).length()==weightsmall)&&(sb==true)){
                System.out.println(list.get(i));
                s=sb=false;

            }
            else if ((b==true)&&(list.get(i).length()==weightbig)&&(sb==true)){
                System.out.println(list.get(i));
                b=sb=false;
            }
        }
    }
}
