package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList <>();
        Queue<File> fileTree = new PriorityQueue<>();

        File rootFile = new File(root);
        Collections.addAll(fileTree, rootFile.listFiles());

        while (!fileTree.isEmpty()){
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()){
                Collections.addAll(fileTree,currentFile.listFiles());
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example");
    }
}
