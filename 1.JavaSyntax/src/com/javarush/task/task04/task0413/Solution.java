package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int stroka = Integer.parseInt(reader.readLine());
        if((stroka<1)||(stroka>7)){
            System.out.println("такого дня недели не существует");
        }
        else if (stroka ==1){
            System.out.println("понедельник");
        }
        else if (stroka ==2){
            System.out.println("вторник");
        }
        else if (stroka ==3){
            System.out.println("среда");
        }
        else if (stroka ==4){
            System.out.println("четверг");
        }
        else if (stroka ==5){
            System.out.println("пятница");
        }
        else if (stroka ==6){
            System.out.println("суббота");
        }
        else if (stroka ==7){
            System.out.println("воскресенье");
        }

    }
}