package com.javarush.task.task14.task1419;

import javax.swing.undo.CannotRedoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) throws Exception {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws Exception {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e9) {
            exceptions.add(e9);
        }
        //java.io.FileNotFoundException
        //напишите тут ваш код

    }
}
