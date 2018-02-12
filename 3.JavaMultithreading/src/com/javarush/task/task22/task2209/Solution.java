package com.javarush.task.task22.task2209;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/changeWords

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <String> listWordsFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(reader.readLine()))){
            while (scanner.hasNext()){
                listWordsFromFile.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String [] words = new String[listWordsFromFile.size()];
        for (int i = 0; i <words.length ; i++) {
            words[i] = listWordsFromFile.get(i);
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();

        if (words.length==0){
            stringBuilder.append("");
        } else {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, words);
            Collections.sort(list);
            for (int i = 0; i <list.size() ; i++) {
                stringBuilder.append(list.get(i)).append(" ");
            }
        }
        return stringBuilder;
    }
}
