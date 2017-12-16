package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException,ParseException{
        PersonScannerAdapter pSA = new PersonScannerAdapter(new Scanner(new File("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/5")));
        Person person = pSA.read();
        System.out.println(person.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException, ParseException {
            fileScanner.useDelimiter("(\\s)|(\\n\r)");
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            String day = fileScanner.next();
            String month = Integer.toString(fileScanner.nextInt());
            String year = fileScanner.next();
            String strdate = day + month + year;
            System.out.println(day+ " "+month+ " "+year);
            //Иванов Иван Иванович 31 12 1950
            Date date = new SimpleDateFormat("ddMMyyyy").parse(strdate);
            return new Person(firstName,middleName,lastName,date);
        }

        @Override
        public void close() throws IOException {
                fileScanner.close();
        }
    }
}
