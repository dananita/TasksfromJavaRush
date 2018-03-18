package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import java.io.IOException;

/**
 * @author Daria Zhuravel
 * @date 11.03.18
 **/
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    /**
     * должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
     * Адрес может быть строкой, содержащей ip, если клиент и сервер
     * запущен на разных машинах или
     * 'localhost', если клиент и сервер работают на одной машине.
     * @return
     */
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("IP: ");
        return ConsoleHelper.readString();
    }

    /**
     * должен запрашивать ввод порта сервера и возвращать его
     * @return
     */
    protected int getServerPort(){
        int result = 0;
        while (true){
            result = ConsoleHelper.readInt();
            break;
        }
        return result;
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }

    /**
     * в данной реализации клиента всегда должен возвращать true
     * (мы всегда отправляем текст введенный в консоль).
     * Этот метод может быть переопределен,
     * если мы будем писать какой-нибудь другой клиент,
     * унаследованный от нашего, который не должен отправлять введенный в консоль текст.
     * @return
     */
    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Connection is false");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread{

    }
}
