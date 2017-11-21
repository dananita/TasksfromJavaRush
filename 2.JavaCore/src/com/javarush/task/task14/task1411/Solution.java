package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> listkey = new ArrayList();

        //тут цикл по чтению ключей, пункт 1
        {   key = reader.readLine();
            while (key.equals("coder")||key.equals("loser")||key.equals("user")||key.equals("proger")){
                if (key.equals("user"))  doWork(new Person.User());
                if (key.equals("coder")) doWork(new Person.Coder());
                if (key.equals("loser")) doWork(new Person.Loser());
                if (key.equals("proger")) doWork(new Person.Proger());
                key = reader.readLine();
            }
            //создаем объект, пункт 2

            //doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
