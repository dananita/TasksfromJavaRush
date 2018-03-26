package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(rootPath);

    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        // если файл, то добавляем в список
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }

        // если директория, то проходим по директории и
        // добавляем все файлы в диретории в список
        if (Files.isDirectory(path)){
         try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){
             for (Path entry: directoryStream) {
                 collectFileList(entry);
             }
         }
        }
    }
}
