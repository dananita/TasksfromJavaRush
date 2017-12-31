package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String fileName;
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
       // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/4
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName=reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String tempStr;
        while ((tempStr = bufferedReader.readLine())!=null){
            list.add(tempStr);
        }
         fileReader.close();

        switch (args[0]){
            case ("-d"):{
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i <list.size() ; i++) {
                    if (!list.get(i).substring(0,8).trim().equals(args[1])){
                        fileWriter.write(list.get(i)+"\n");
                    }
                }
                fileWriter.close();
                break;
            }
            case ("-u"):{
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i <list.size() ; i++) {
                    if (!list.get(i).substring(0,8).trim().equals(args[1])){
                        fileWriter.write(list.get(i)+"\n");
                    } else {
                        String result = String.format("%-8s%-30s%-8s%-4s", args[1] ,args[2], args[3], args[4]);
                        fileWriter.write(result+"\n");
                    }
                }
                fileWriter.close();
                break;
            }
            default:{
                break;
            }

        }
    }

}
