package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] element = new Thread().currentThread().getStackTrace();
        String s=element[2].getMethodName();
        System.out.println(s);
        return s;
    }

    public static String method2() {
        method3();
        StackTraceElement[] element = new Thread().currentThread().getStackTrace();
        String s=element[2].getMethodName();
        System.out.println(s);
        return s;//напишите тут ваш код
    }

    public static String method3() {
        method4();
        StackTraceElement[] element = new Thread().currentThread().getStackTrace();
        String s=element[2].getMethodName();
        System.out.println(s);
        return s;
        //напишите тут ваш код
    }

    public static String method4() {
        method5();
        StackTraceElement[] element = new Thread().currentThread().getStackTrace();
        String s=element[2].getMethodName();
        System.out.println(s);
        return s;
        //напишите тут ваш код
    }

    public static String method5() {
        //напишите тут ваш код
        StackTraceElement[] element = new Thread().currentThread().getStackTrace();
        String s=element[2].getMethodName();
        System.out.println(s);
        return s;
    }
}
