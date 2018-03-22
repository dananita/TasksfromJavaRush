package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class Archiver {
    public static void main(String[] args) {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Path fileArchive = Paths.get(reader.readLine());
            Path fileThatIsArchived = Paths.get(reader.readLine());
            ZipFileManager zipFileManager = new ZipFileManager(fileArchive);
            zipFileManager.createZip(fileThatIsArchived);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        ExitCommand exitCommand = new ExitCommand();
        try {
            exitCommand.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Operation operation;
        while (true){
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
                if (operation.equals(Operation.EXIT)) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static Operation askOperation() throws Exception{
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage("0 - упаковать файлы в архив");
        ConsoleHelper.writeMessage("1 - добавить файл в архив");
        ConsoleHelper.writeMessage("2 - удалить файл из архива");
        ConsoleHelper.writeMessage("3 - распаковать архив");
        ConsoleHelper.writeMessage("4 - просмотреть содержимое архива");
        ConsoleHelper.writeMessage("5 - выход");
        int consoleNumber = ConsoleHelper.readInt();
        Operation result = null;
        switch (consoleNumber){
            case 0: {result = Operation.CREATE; break;}
            case 1: {result = Operation.ADD; break;}
            case 2: {result = Operation.REMOVE; break;}
            case 3: {result = Operation.EXTRACT; break;}
            case 4: {result = Operation.CONTENT; break;}
            case 5: {result = Operation.EXIT; break;}
        }
        return result;
    }
}
