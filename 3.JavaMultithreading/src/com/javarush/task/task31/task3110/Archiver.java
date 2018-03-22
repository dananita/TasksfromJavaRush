package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class Archiver {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Path fileArchive = Paths.get(reader.readLine());
            Path fileThatIsArchived = Paths.get(reader.readLine());
            ZipFileManager zipFileManager = new ZipFileManager(fileArchive);
            zipFileManager.createZip(fileThatIsArchived);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
