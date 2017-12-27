package com.javarush.task.task19.task1919;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Считаем зарплаты
*/
//Петров 2
//Сидоров 6
//Иванов 1.35
//Петров 3.1
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/9
public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileReader fileReader = new FileReader(args[0]);
        int oneBytesFromFile;
        StringBuilder stringBuilder = new StringBuilder();
        while ((oneBytesFromFile=fileReader.read())!=-1){
            stringBuilder.append((char)oneBytesFromFile);
        }
        fileReader.close();


        TreeMap <String,Float> map = new TreeMap<>();
        String[] str = stringBuilder.toString().split("\\s");

        for (int i = 0; i <str.length ; i=i+2) {
            if (!map.containsKey(str[i])){
            map.put(str[i],Float.parseFloat(str[i+1]));
            }
            else{
                map.put(str[i],map.get(str[i])+Float.parseFloat(str[i+1]));
            }
        }
        for (Map.Entry pair: map.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }
}
