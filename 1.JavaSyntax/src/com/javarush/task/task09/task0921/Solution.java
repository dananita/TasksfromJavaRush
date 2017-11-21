package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try{
            while (true) {
                int s = Integer.parseInt(reader.readLine());
                list.add(s);
            }
        }
        catch (Exception e){
        }
        finally {
            for (int p = 0; p<list.size();p++) {
                System.out.println(list.get(p));
            }
        }
    }
}
