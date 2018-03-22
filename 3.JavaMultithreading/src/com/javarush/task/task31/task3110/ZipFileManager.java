package com.javarush.task.task31.task3110;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public void createZip (Path source) throws Exception{
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            String fileNameSource = source.getFileName().toString();
            ZipEntry zipEntry = new ZipEntry(fileNameSource);
                zipOutputStream.putNextEntry(zipEntry);
                try (
                        InputStream inputStream = Files.newInputStream(source)) {
                    while (inputStream.available() > 0) {
                        zipOutputStream.write(inputStream.read());
                    }
                }
        }
    }
}
