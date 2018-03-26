package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class ZipCreateCommand extends  ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации");
            Path entityForAchive = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(entityForAchive);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
