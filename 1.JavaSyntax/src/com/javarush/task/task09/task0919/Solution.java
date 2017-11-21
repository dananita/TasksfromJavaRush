package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) throws Exception{
        try {
            divisionByZero();
        }
        catch (ArithmeticException e){
          printStackTrace(e);
        }
    }
    public static void divisionByZero(){
            System.out.println(5/ 0);
    }
    public static void  printStackTrace(Exception e){
        e.printStackTrace();
    }
}
