package com.javarush.task.task17.task1721;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        fillLists();
        new Solution().joinData();
    }

    private static void fillLists() throws IOException{
        Scanner scanner = new Scanner(System.in);
        String nameFile1 = scanner.nextLine();
        String nameFile2 = scanner.nextLine();

        allLines = Files.lines(Paths.get(nameFile1), StandardCharsets.UTF_8).collect(Collectors.toList());
        forRemoveLines = Files.lines(Paths.get(nameFile2),StandardCharsets.UTF_8).collect(Collectors.toList());
    }

    public void joinData () throws CorruptedDataException {
        for (String tmp:forRemoveLines) {
            if (allLines.contains(tmp)){
                allLines.remove(tmp);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
