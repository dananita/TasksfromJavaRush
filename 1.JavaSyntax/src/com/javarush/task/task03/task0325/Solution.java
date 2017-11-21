package com.javarush.task.task03.task0325;

import java.io.*;
import java.util.Scanner;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()!=true); {
            int number = sc.nextInt();
            System.out.println("Я буду зарабатывать $" + number +
                    " в час");
        }
    }
}
