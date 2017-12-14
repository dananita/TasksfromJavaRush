package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempNameFile;
        while (!(tempNameFile=reader.readLine()).equals("exit")){
            ReadThread readThread = new ReadThread(tempNameFile);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        private FileReader fIS;

        public ReadThread(String fileName) {
            //implement constructor body
            try {
                this.fIS = new FileReader(fileName);
                int tempOneBytes;
                int maxFreq=0;
                try {
                    HashMap <Integer,Integer> map = new HashMap<>();
                    while ((tempOneBytes = fIS.read()) != -1) {
                        if (map.containsKey(tempOneBytes)) {
                            map.put(tempOneBytes, map.get(tempOneBytes) + 1);
                            if ((map.get(tempOneBytes) + 1) > maxFreq) maxFreq = map.get(tempOneBytes);
                        }else {
                            map.put(tempOneBytes,1);
                        }
                    }
                    for (Map.Entry<Integer,Integer> pair:map.entrySet()) {
                        if (pair.getValue()==maxFreq){
                            //System.out.println(pair.getKey()+" "+pair.getValue()+" "+maxFreq);
                            resultMap.put(fileName,pair.getKey());
                        }
                    }
                    fIS.close();

                }catch (IOException ex){
                    /* NOP */
                }
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException: This word is not a file.");
            }
        }
    }
}
