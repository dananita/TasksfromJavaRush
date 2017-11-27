package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat formatOutput = new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat formatInput = new SimpleDateFormat( "dd/MM/yyyy", Locale.ENGLISH);
            switch (args[0]) {
                case ("-c"): {
                    synchronized (allPeople) {
                        try {
                            for (int i = 1; i < args.length; i += 3) {
                                Person person = null;
                                if (args[i + 1].equals("м")) {
                                    person = Person.createMale(args[i], formatInput.parse(args[i + 2]));
                                } else if (args[i + 1].equals("ж")) {
                                    person = Person.createFemale(args[i], formatInput.parse(args[i + 2]));
                                }
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                        } catch (ParseException e) {
                            System.out.println("Parse error in block create");
                        }
                    }
                    break;
                }
                case  ("-d"):{
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                        }
                    }
                    break;
                }
                case ("-u"):{
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                            if (args[i + 2].equals("м")) {
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                            } else if (args[i + 2].equals("ж")) {
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                            }
                            allPeople.get(Integer.parseInt(args[i])).setBirthDay(formatInput.parse(args[i + 3]));
                        }
                    }
                    break;
                }
                case ("-i"): {
                    synchronized (allPeople) {
                        for (int i = 1; i <args.length ; i++) {
                            String sex = (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE))? "м": "ж";
                            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName()+" "+
                                    sex+ " "+
                                    formatOutput.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));

                        }
                    }
                    break;
                }
                default:{
                    synchronized (allPeople){
                        throw new IllegalArgumentException();
                    }
                }
            }
    }

}
