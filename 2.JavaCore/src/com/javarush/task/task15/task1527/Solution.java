package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            s = s.replace(s.substring(0,s.indexOf("?")+1),"");
            String massiv[] = s.split("&");
            String value = null;
            for (int i = 0; i <massiv.length ; i++) {
                if (massiv[i].split("=")[0].equals("obj")){
                    value = massiv[i].split("=")[1];
                }
                System.out.println(massiv[i].split("=")[0]+" ");
            }
            if (value!=null){
                System.out.println();
                try{
                    System.out.println();
                    alert(Double.parseDouble(value));
                } catch (Exception e){
                    alert(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
