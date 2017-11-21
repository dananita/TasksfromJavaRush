package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        SimpleDateFormat format0 = new SimpleDateFormat("MM/dd/yyyy");
        Date datenew = format0.parse(reader.readLine());

        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        System.out.println(format.format(datenew).toUpperCase());
    }
}
