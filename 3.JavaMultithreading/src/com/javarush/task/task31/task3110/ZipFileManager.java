package com.javarush.task.task31.task3110;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/

import java.nio.file.Path;

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

    }
}
