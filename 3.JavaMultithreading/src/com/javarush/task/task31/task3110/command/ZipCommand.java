package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public abstract class ZipCommand implements Command{
    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Прошу ввести полный путь файла архива");
        String fileAbsolutePath = ConsoleHelper.readString();
        Path absolutePathFromCliet = Paths.get(fileAbsolutePath);
        ZipFileManager zipFileManager = new ZipFileManager(absolutePathFromCliet);
        return zipFileManager;
    }
}
