package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/13
        /*
        Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
        </span></b></span><span>Super</span><span>girl</span>
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int tempOneByte;
        while ((tempOneByte = fileReader.read()) != -1) {
            stringBuilder.append((char) tempOneByte);
        }
        fileReader.close();

        stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll("\\n", ""));
        ArrayList <Integer> listOpenedTags = new ArrayList<>();
        Matcher m = Pattern.compile("(<" + args[0] + ")?(</" + args[0] + ")?").matcher(stringBuilder);
        String s="";
        while (m.find()) {
            if (m.group(1) != null && m.group(1).equals("<" + args[0])) {
                listOpenedTags.add(m.start());
            } else if (m.group(2) != null && m.group(2).equals("</" + args[0])) {
                if (listOpenedTags.size()==1){
                    System.out.println(stringBuilder.substring(listOpenedTags.get(listOpenedTags.size() - 1), m.end() + 1));
                    listOpenedTags.remove(listOpenedTags.size() - 1);
                    if (!s.equals("")) {
                        System.out.println(s);
                        s="";
                    }
                } else {
                    s = stringBuilder.substring(listOpenedTags.get(listOpenedTags.size() - 1), m.end() + 1);
                    listOpenedTags.remove(listOpenedTags.size() - 1);
                }
            }
        }
    }
}
