package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double number = Double.parseDouble(reader.readLine());
        int k = 0;
        if (number>=0){
            if (number>60) {
                k = (int) (number / 60);
               // System.out.println(k);
                number = number % (60 * k);
            }
            poisk(number);
        }
    }

    public static void poisk (double number){
        boolean colorgreen = true, coloryellow = false, colorred = false;
        double i = 0;
        while (i <=number){
            if (colorgreen ==true){
                i=i+3;
                colorgreen=false;
                coloryellow = true;
            }
            else if (coloryellow==true){
                    i=i+1;
                    coloryellow=false;
                    colorred = true;
            }
            else if (colorred == true){
                i=i+1;
                colorred = false;
                colorgreen = true;
            }
        }
      //  if (number == 0){System.out.println("зеленый");}
        if (coloryellow == true) {
        System.out.println("зелёный");}
        if (colorgreen == true){
            System.out.println("красный");
        }
        if (colorred == true){
            System.out.println("желтый");
        }
    }
}