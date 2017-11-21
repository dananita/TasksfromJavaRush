package com.javarush.task.task03.task0305;
import java.text.SimpleDateFormat;
import java.util.Date ;


public class Solution {
    public static void main(String[] args) {
        Date dateBirthday = new Date(86,00,12);
        SimpleDateFormat format1 = new SimpleDateFormat("MMMM d YYYY");
        System.out.println(format1.format(dateBirthday).toUpperCase());
    }
}
