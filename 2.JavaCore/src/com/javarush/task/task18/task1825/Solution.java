package com.javarush.task.task18.task1825;


import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
Собираем файл
*/

/*
/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/su.part1
/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/su.part2
end
*/

public class Solution {
    public static void main(String[] args)  throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempstr;
        ArrayList <String> listNameFile = new ArrayList<>();
            while (!(tempstr = reader.readLine()).equals("end")){
            listNameFile.add(tempstr);
            }
            Collections.sort(listNameFile);
            if (!listNameFile.isEmpty()) {
               /* Matcher m = Pattern.compile("(.*)\\.part\\d+$").matcher(listNameFile.get(0));
                m.find();
                String file2 = m.group();   //не принимает валидатор*/
                String file2 = listNameFile.get(0).substring(0,listNameFile.get(0).lastIndexOf("."));
                FileOutputStream fOS = new FileOutputStream(new File(file2),true);

                for (int i = 0; i < listNameFile.size(); i++) {
                    FileInputStream fIS = new FileInputStream(listNameFile.get(i));
                    byte[] buffer = new byte[(int) fIS.getChannel().size()];
                    fIS.read(buffer);
                    fOS.write(buffer);
                    fIS.close();
                }
                fOS.close();
                reader.close();
            }
    }
}
