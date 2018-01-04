package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties propertiesFromJava = new Properties();
    public static String filename;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(filename);
        load(fis);
        fis.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        propertiesFromJava.clear();
        for (Map.Entry pair:properties.entrySet()) {
            propertiesFromJava.put(pair.getKey(),pair.getValue());
        }
        propertiesFromJava.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        propertiesFromJava.load(inputStream);
        for (Map.Entry pair: propertiesFromJava.entrySet()) {
            properties.put((String)pair.getKey(),(String)pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        FileOutputStream fos = new FileOutputStream(Solution.filename);
        solution.save(fos);
        fos.close();
    }
}
