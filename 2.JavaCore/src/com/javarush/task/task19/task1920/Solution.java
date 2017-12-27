package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
         int tempOneBytes;
         StringBuilder stringBuilder = new StringBuilder();
        while((tempOneBytes=reader.read())!=-1){
            stringBuilder.append((char)tempOneBytes);
        }
        reader.close();

        HashMap<String,Float> map = new HashMap<>();
        String[]strings = stringBuilder.toString().split("\\s");
        for (int i = 0; i <strings.length ; i=i+2) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], Float.parseFloat(strings[i + 1]) + map.get(strings[i]));
            }
            else{
                map.put(strings[i],Float.parseFloat(strings[i+1]));
                }
            }

        Float maxValueMap = Collections.max(map.values());
        for (Map.Entry<String, Float> pair:map.entrySet() ){
            if(pair.getValue().equals(maxValueMap))
            System.out.println(pair.getKey());
        }
    }
}
