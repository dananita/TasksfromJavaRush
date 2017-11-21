package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stroka="";
        ArrayList<String> listNumber = new ArrayList<String>();
        Collections.addAll(listNumber,"0","-","1","2","3","4","5","6","7","8","9",".");


        while (true){
            stroka = reader.readLine();
            if(stroka.contains("exit"))break;
            try{
                if (stroka.contains(".")) {
                    int l = stroka.indexOf(".");
                    if (stroka.indexOf(".", l + 1) > 0) {
                        print(stroka);
                    } else {
                        print(Double.parseDouble(stroka));
                    }
                } else {
                    if ((Integer.parseInt(stroka) > 0) && (Integer.parseInt(stroka) < 128)) {
                        print(Short.parseShort(stroka));
                    } else {
                        if ((Integer.parseInt(stroka) <= 0) || (Integer.parseInt(stroka) >= 128)) {
                            print(Integer.parseInt(stroka));}
                    }
                }
            } catch (NumberFormatException e) { print(stroka);}
        }
    }

    public static void print(Double value) {System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
