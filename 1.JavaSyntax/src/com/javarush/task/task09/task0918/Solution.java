package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.FileSystemException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends CharConversionException{
    }

    static class MyException2 extends IndexOutOfBoundsException {
    }

    static class MyException3 extends ArithmeticException{
    }

    static class MyException4 extends IOException{
    }
}

