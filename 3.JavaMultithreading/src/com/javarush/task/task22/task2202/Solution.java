package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        String result= "";
        try{
        if (string == null||string.isEmpty() ) throw new TooShortStringException();
        if (string.split(" ").length<5) throw new TooShortStringException();
            String [] massivStringFor4Space = string.split(" ");
            result = massivStringFor4Space[1]+" "+
                    massivStringFor4Space[2]+" "+
                    massivStringFor4Space[3]+" "+
                    massivStringFor4Space[4];
        } catch (Exception e){
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException{
        public TooShortStringException() {
        }
    }
}
