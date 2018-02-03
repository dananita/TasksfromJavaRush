package com.javarush.task.task31.task3106;

/* 
Разархивируем файл
*/

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/resultForZip
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/pmbok2004_rus.doc.zip.000  - 009
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/test2.zip.000 - 001
public class Solution {

    public static void main(String[] args) throws IOException {
     Vector<FileInputStream> listFiles = new Vector();
     ArrayList<String> argsSort = new ArrayList<>();
        for (int i = 1; i < args.length ; i++) {
            argsSort.add(args[i]);
        }
        Collections.sort(argsSort);
        for (int i = 0; i <argsSort.size(); i++) {
            listFiles.add(new FileInputStream(argsSort.get(i)));
        }

        Enumeration enumeration = listFiles.elements();

        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        ZipInputStream is = new ZipInputStream(sequenceInputStream);
        try {
            ZipEntry entry=null;
            while ((entry = is.getNextEntry()) != null) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(args[0],true));
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1;) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                    os.close();
            }
        } finally {
            is.close();
        }
    }
}

