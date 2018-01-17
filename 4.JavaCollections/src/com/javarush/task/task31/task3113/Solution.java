package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution{
    private static int countFile;
    private static int countDir;
    private static int countSizeofDir;
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (Files.isDirectory(path)) {
            countFile = countDir = 0;
            countSizeofDir = 0;

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countFile++;
                    countSizeofDir += Files.size(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!dir.equals(path)) {
                        countDir++;
                    }

                    return super.postVisitDirectory(dir, exc);
                }
            });
            System.out.println("Всего папок - " + countDir);
            System.out.println("Всего файлов - " + countFile);
            System.out.println("Общий размер - " + countSizeofDir);
        } else {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }
    }
}
