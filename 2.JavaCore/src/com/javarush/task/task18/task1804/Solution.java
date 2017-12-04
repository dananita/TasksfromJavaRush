package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Task17.10

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        // получаю с файла byte и складываю в мапу, если не было элемента то 1,
        // если был уже такой элемент, то увеличиваем значение на 1.

        while (fileInputStream.available()>0){
            Integer element = fileInputStream.read();
            Integer count =  hashMap.get (element);
            if (count == null) count = 0;
            hashMap.put(element,++count);
        }
        fileInputStream.close();
        reader.close();

        int mincount = Collections.min(hashMap.values());
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()
             ) {
            if (entry.getValue().equals(mincount))
                System.out.print(entry.getKey()+ " ");
        }
    }
}
