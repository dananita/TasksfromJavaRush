package com.javarush.task.task19.task1921;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader reader = new FileReader(args[0]);
        int tempOneByte;
        StringBuilder stringBuilder = new StringBuilder();
        while((tempOneByte=reader.read())!=-1){
            stringBuilder.append((char)tempOneByte);
        }
        reader.close();

        Matcher m = Pattern.compile("(\\D+)(\\d+ \\d+ \\d+)").matcher(new String(stringBuilder).replaceAll("\\s"," "));
        String name;
        String dateBirthday;
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        while (m.find()){
            name = m.group(1);
            dateBirthday = m.group(2);
            PEOPLE.add(new Person(name.trim(),format.parse(dateBirthday)));
        }
        for (Person people:PEOPLE) {
            System.out.println("Name and Date Birthday = "+people.getName()+" : "+people.getBirthday());
        }
    }
}
