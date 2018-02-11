package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/forPair
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            Scanner inFile = new Scanner(new File(reader.readLine())).useDelimiter("\\s");

            List <String> listFileReader = new ArrayList<>();
            //HashMap <String,Boolean> mapFileReader = new HashMap<>();
             while (inFile.hasNext()){
                String text = inFile.next();
                listFileReader.add(text);
             //    mapFileReader.put(text,true);
             }
            String [] arrayWordsFromFile = new String[listFileReader.size()];
            Boolean [] arrayWordsBoolean = new Boolean[listFileReader.size()];
            for (int i = 0; i <arrayWordsBoolean.length ; i++) {
                arrayWordsBoolean[i] = true;
            }
             listFileReader.toArray(arrayWordsFromFile);

            for (int i = 0; i <arrayWordsFromFile.length ; i++) {
                for (int j = arrayWordsFromFile.length-1; j > i ; j--) {
                    if (arrayWordsFromFile[i].equals(new StringBuilder(arrayWordsFromFile[j]).reverse().toString())){
                        if (arrayWordsBoolean[i]==true && arrayWordsBoolean[j]==true) {
                            Pair pair = new Pair();
                            pair.first = arrayWordsFromFile[i];
                            //pair.second = new StringBuilder(arrayWordsFromFile[j]).reverse().toString();
                            pair.second = arrayWordsFromFile[j];
                            result.add(pair);
                            arrayWordsBoolean[i]=false;
                            arrayWordsBoolean[j]=false;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Pair p:
             result) {
            System.out.println(p.first+" "+p.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
