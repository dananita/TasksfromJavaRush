package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/changeWords

        List<String> listWordsFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             Scanner scanner = new Scanner(new File(reader.readLine()))) {
            while (scanner.hasNext()) {
                listWordsFromFile.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = new String[listWordsFromFile.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = listWordsFromFile.get(i);
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder resultStringBuilder = new StringBuilder();
        StringBuilder[] tempFoundWord = new StringBuilder[words.length];

        if (words.length == 0) {
            resultStringBuilder.append("");
        } else {
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                tempFoundWord[i] = findTheNextWordWithTheLastLetter(i, words);
                if (resultStringBuilder.length() < tempFoundWord[i].length()) {
                    resultStringBuilder = tempFoundWord[i];
                }
            }
        }

        return resultStringBuilder;
    }

    private static StringBuilder findTheNextWordWithTheLastLetter(int iWord, String[] words) {
        StringBuilder str = new StringBuilder();
        if (words != null) {
            str.append(words[iWord]);
            words[iWord] = "";
            for (int i = 1; i < words.length; i++) {
                for (int j = 1; j < words.length; j++) {
                    if (!words[j].equals("")) {

                        if (Character.toLowerCase(words[j].charAt(0)) ==
                                Character.toLowerCase(str.charAt(str.length() - 1))) {
                            str.append(" " + words[j]);
                            words[j] = "";
                        } else if (Character.toLowerCase(words[j].charAt(words[j].length() - 1)) ==
                                Character.toLowerCase(str.charAt(0))) {
                            str.insert(0, words[j] + " ");
                            words[j] = "";
                        }
                    }
                }
            }
        }
        return str;
    }
}
