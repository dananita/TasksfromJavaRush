package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/*
Добавление файла в архив
*/
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/test.zip
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result.mp3
public class Solution {

    public static void main(String[] args) throws IOException {
        File fileArgs0 = new File(args[0]);
        String zipFile = args[1];

        Map<String, ByteArrayOutputStream> mapWithArchivedFiles = new HashMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipInputStream.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);

                mapWithArchivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry zipEntry = new ZipEntry("new/" + fileArgs0.getName());
            zipOutStream.putNextEntry(zipEntry);
            Files.copy(fileArgs0.toPath(), zipOutStream);

            for (Map.Entry<String, ByteArrayOutputStream> pair : mapWithArchivedFiles.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(fileArgs0.getName())) continue;
                zipOutStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutStream.write(pair.getValue().toByteArray());
            }
        }
    }

    public static void solutionWithFilesystem(String[] args) throws IOException{
        //Создание временной директории для последующей записи в нее файлов
        File tempdir = new File("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/" + File.separator + "tempdir");
        tempdir.mkdir();
        // запись файла во временную директорию с папкой new
        File fileArgs0 = new File(args[0]);
        File fileCopy = new File(tempdir.getAbsolutePath() + File.separator + "new");
        fileCopy.mkdirs();
        fileCopy = new File(fileCopy.getAbsoluteFile() + File.separator + fileArgs0.getName());
        //fileCopy.createNewFile();
        Files.copy(Paths.get(fileArgs0.toString()),Paths.get(fileCopy.toString()));

        // запись архивных данных во временную директорию
        try (   FileInputStream fileInputStream = new FileInputStream(args[1]);
                ZipInputStream zip = new ZipInputStream(fileInputStream)) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                File tempfile = new File(tempdir, entry.getName());
                FileOutputStream fos = new FileOutputStream(tempfile);
                for (int c = zip.read(); c != -1; c = zip.read()) {
                    fos.write(c);
                }
                zip.closeEntry();
                fos.close();
            }
        }

        // запись в zipфайл
        try (ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(args[1]))) {
            List<String> result = getFileTree(tempdir.getAbsolutePath());

            for (String s: result) {
                String stringRelativePathToFile = s.replace((tempdir.getAbsolutePath()+File.separator).toString(),"");
                ZipEntry zipEntry = new ZipEntry(stringRelativePathToFile);
                zipout.putNextEntry(zipEntry);
                try(FileInputStream fis = new FileInputStream(s)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zipout.write(buffer);
                    fis.close();
                }
            }
            zipout.closeEntry();
        }
    }

    public static List<String> getFileTree(String NameRootDir) throws IOException {

        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        File rootFile = new File(NameRootDir);
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
}


