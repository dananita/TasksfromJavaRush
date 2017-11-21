package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //-c Миронов м 15/04/1990
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        try {
            switch (args[0]) {
                case "-i": {
                    String sex = (!allPeople.get(Integer.parseInt(args[1])).getSex().equals("FEMALE")) ? "м" : "ж";
                    System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                            sex + " " +
                            format.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
                    break;
                }
                case "-d": {
                    allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                    allPeople.get(Integer.parseInt(args[1])).setName(null);
                    allPeople.get(Integer.parseInt(args[1])).setSex(null);
                    break;
                }
                case "-c": {
                    Person per1;
                    if (args[2].equals("м")) {
                        per1 = Person.createMale(args[1], format2.parse(args[3]));
                    }
                    else{
                        per1 = Person.createFemale(args[1], format2.parse(args[3]));
                    }
                    allPeople.add(per1);
                    System.out.println(allPeople.indexOf(per1));
                    break;
                }
                case "-u": {
                    Person per2 = allPeople.get(Integer.parseInt(args[1]));
                    per2.setName(args[2]);
                    if (args[3].equals("м")) per2.setSex(Sex.MALE);
                    else per2.setSex(Sex.FEMALE);
                    per2.setBirthDay(format2.parse(args[4]));
                }
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
}
