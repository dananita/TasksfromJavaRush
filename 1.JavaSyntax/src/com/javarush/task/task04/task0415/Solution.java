package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import jdk.nashorn.internal.ir.IfNode;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        if (a<(b+c)){
            if (b<(a+c)){
                if (c<(a+b)){
                    System.out.println("Треугольник существует.");
                }
                else{
                    System.out.println("Треугольник не существует.");
                }
            }
            else{
                System.out.println("Треугольник не существует.");
            }
        }
        else{
            System.out.println("Треугольник не существует.");
        }

    }
}