package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream file = new FileInputStream(args[0]);
        byte[]buffer = new byte[(int) file.getChannel().size()];
        file.read(buffer);
        Arrays.sort(buffer);

        HashMap<Byte,Integer> mapSymbols = new HashMap<>();
        int countbufferSymbol;
        for (byte x : buffer) {
            countbufferSymbol = 0;

            for (byte x1 : buffer) {
                if (x == x1) {
                    countbufferSymbol++;
                }
            }
            if (!mapSymbols.containsKey(x)) {
                mapSymbols.put(x, countbufferSymbol);
                System.out.println((char) x + " " + countbufferSymbol);
            }
        }
        file.close();
    }
}
