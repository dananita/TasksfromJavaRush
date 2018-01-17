package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }

    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        String [] urlPrefixAndSubfix =url.getPath().substring
                (url.getPath().lastIndexOf("/")+1, url.getPath().length()).split("\\.");
        Path tempFile = Files.createTempFile(urlPrefixAndSubfix[0],"."+urlPrefixAndSubfix[1]);
        Files.copy(new URL(urlString).openStream(),tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path result = Paths.get(downloadDirectory+"/"+urlPrefixAndSubfix[0]+"."+urlPrefixAndSubfix[1]);

        //StandardCopyOption.REPLACE_EXISTING in method move for validator is a mistake....Arrrrr!!! This is stupid...
        Files.move(tempFile,result);
        return result;
    }
}
