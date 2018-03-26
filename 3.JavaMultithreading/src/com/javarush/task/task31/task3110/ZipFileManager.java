package com.javarush.task.task31.task3110;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip)
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        // Проверяем существование директории, в которой будет создаваться архив
        // при осутствии директории создаем
        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectory(zipFile.getParent());
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path pathFilenames : fileNames) {
                    addNewZipEntry(zipOutputStream, source, pathFilenames);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))){
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream,zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception{
        int byteOne;
        while ((byteOne = in.read()) != -1){
            out.write(byteOne);
        }
    }

}
