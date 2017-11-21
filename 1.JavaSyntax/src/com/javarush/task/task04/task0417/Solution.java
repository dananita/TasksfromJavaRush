package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        String s = "";
        if (((comparison(number1,number2)==true)&&(comparison(number2,number3)==true))&&(comparison(number1,number3)==true)){
            s= number1+" "+number1+" "+ number1;
        }
        else if (comparison(number1,number2)== true){
            s=number1+" "+number2;
            //System.out.println(number1+" "+number2);
        }

        else if (comparison(number2,number3) == true){
           // System.out.println(number2+" "+number3);
            s=number2+" "+number3;
        }
        else if (comparison(number1,number3) == true){
           // System.out.println(number1+" "+number3);
            s=number1+" "+number3;
        }
        if (s!=""){System.out.println(s);}
    }

    public static boolean comparison (int a, int b){
        if (a==b){
            return true;
        }
        return false;
    }
}