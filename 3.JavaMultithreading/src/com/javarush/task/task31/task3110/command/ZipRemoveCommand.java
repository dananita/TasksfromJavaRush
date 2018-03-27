package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class ZipRemoveCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Какой адрес архива из которого удаляем файл?");
        Path achive = Paths.get(ConsoleHelper.readString());
        ConsoleHelper.writeMessage("Какой файл удаляем?");
        Path fileDelete = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(fileDelete);
    }
}
