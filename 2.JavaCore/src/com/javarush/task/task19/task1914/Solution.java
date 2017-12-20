package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        int resultOperation = 0;
        String [] charsresult = result.split(" ");
        switch (charsresult[1]){
            case "+":
                resultOperation= Integer.parseInt(charsresult[0])+ Integer.parseInt(charsresult[2]);
                break;
            case "-":
                resultOperation= Integer.parseInt(charsresult[0])- Integer.parseInt(charsresult[2]);
                break;
            case "*":
                resultOperation= Integer.parseInt(charsresult[0])* Integer.parseInt(charsresult[2]);
                break;
            case "/":
                resultOperation= Integer.parseInt(charsresult[0])/ Integer.parseInt(charsresult[2]);
                break;
        }

        StringBuilder stringBuilder = new StringBuilder(result.replaceAll("\r?\n?","")+Integer.toString(resultOperation));

        System.out.println(stringBuilder);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

