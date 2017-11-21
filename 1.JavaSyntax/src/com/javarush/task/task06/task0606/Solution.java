package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int number = Integer.parseInt(s);
        for (int i = s.length(); i>0 ; i--) {
            if ((int)(number/Math.pow(10,(double)i-1)%2)==0){
                even++;
            }
            else {odd++;}
            number =(int)(number%Math.pow(10,(double)i-1));
        }
        System.out.println("Even: "+even+" Odd: "+odd);
    }
}
