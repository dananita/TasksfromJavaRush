package com.javarush.task.task19.task1916;

import sun.java2d.pipe.BufferedRenderPipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();


        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        while(true){
            if(reader1.ready()){
                if (reader2.ready()) {
                    reader1.mark(500);
                    reader2.mark(500);
                    file1 = reader1.readLine();
                    file2 = reader2.readLine();
                    if (file2.equals(file1)) {
                        lines.add(new LineItem(Type.SAME, file1));
                    } else {
                        if (file1.equals(reader2.readLine())){
                            reader1.reset();
                            reader2.reset();
                            lines.add(new LineItem(Type.ADDED,reader2.readLine()));
                        } else {
                            lines.add(new LineItem(Type.REMOVED,file1));
                            reader2.reset();
                        }
                    }
                } else lines.add(new LineItem(Type.REMOVED,reader1.readLine()));
            } else {
                if (reader2.ready()) lines.add(new LineItem(Type.ADDED, reader2.readLine()));
                else break;
            }

        }
        reader1.close();
        reader2.close();

        for (LineItem item:lines) {
            System.out.println(item.type + " "+ item.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
