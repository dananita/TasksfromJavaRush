package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String stroka = buffer.readLine();
        int count  = Integer.parseInt(buffer.readLine());
        while (count>0){
            System.out.println(stroka);
            count--;
        }
    }
}
