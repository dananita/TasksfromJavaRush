package com.javarush.task.task18.task1827;

/* 
Прайсы
*/


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> lists = new ArrayList<>();
        while ((line = fileReader.readLine()) != null){
            lists.add(line);
        }
        fileReader.close();

        if (args[0].equals("-c")){

            int maxID = Integer.MIN_VALUE;

            for (String s: lists){
                int idName = Integer.parseInt(s.substring(0,8).trim());
                if (idName > maxID) maxID = idName;
            }
            String id = String.valueOf(++maxID).concat("        ").substring(0,8);
            String prodactName = "";
            for (int j = 1; j < args.length - 2; j++){
                prodactName = prodactName.concat(args[j]);
            }
            System.out.println(prodactName);
            prodactName = prodactName.concat("                              ").substring(0,30);
            String price = args[args.length - 2].concat("        ").substring(0,8);
            String quantity = args[args.length - 1].concat("    ").substring(0,4);
            String result = id.concat(prodactName.concat(price.concat(quantity)));
            lists.add(result);


            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: lists){
                fileWriter.write(s);
                fileWriter.newLine();
            }
            fileWriter.close();
        }
    }
    /*public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File nameFile = new File (reader.readLine());
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(nameFile));
        Integer maxID=0;
        String tempstr;
        while ((tempstr=br.readLine())!=null){
            list.add(tempstr);
        }
        br.close();
        if (args[0].equals("-c")){
            String productName="";
            for (int i = 1; i < args.length-2; i++) {
                productName += args[i]+" ";
            }
            for (String s:list) {
                int tempId = Integer.parseInt(s.substring(0,8).trim());
                if(tempId>maxID) maxID=tempId;
            }
            maxID++;
            list.add(String.format("%-8d%-30.30s%-8.2f%-4d",maxID,productName,Double.parseDouble(args[args.length-2]),Integer.parseInt(args[args.length-1])));
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nameFile));
        for (String s:list) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileWriter.close();
    }*/
}
