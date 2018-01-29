package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile){
        Path path = Paths.get(pathToFile);
        try {
            fileData = new ConcreteFileData(Files.isHidden(path),
                    Files.isExecutable(path),
                    Files.isDirectory(path),
                    Files.isWritable(path));
        } catch (IOException e) {
            NullFileData nullObject = new NullFileData(new Exception());
            fileData = nullObject;
        }
    }

    public FileData getFileData() {
        return fileData;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/");

    }
}
