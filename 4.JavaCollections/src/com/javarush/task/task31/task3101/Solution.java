package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;

/*
Проход по дереву файлов
*/
public class Solution {
    public static ArrayList<File> listFile = new ArrayList();

    public static void main(String[] args) {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {
            processFilesFromFolder(path.getPath());
            listFile.sort(new FileNameComparator());

            for (File filelist : listFile) {
                FileInputStream fileInputStream = new FileInputStream(filelist);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileInputStream.close();

                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processFilesFromFolder(String path) {
        File[] folderEntries = new File(path).listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry.getAbsolutePath());
                continue;
            }

            if (entry.isFile()) {
                if (entry.length() > 50) {
                    FileUtils.deleteFile(entry);
                } else {
                    listFile.add(entry);
                }
            }
        }
    }
}
