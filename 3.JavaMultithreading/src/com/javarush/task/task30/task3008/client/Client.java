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

    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            try {
                synchronized (this){
                    this.wait();
                }

            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error");
                System.exit(1);
            }

            if (clientConnected){
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
            while (clientConnected){
                    String s  = ConsoleHelper.readString();
                    if (!s.equalsIgnoreCase("exit")){
                        if (shouldSendTextFromConsole()){
                            sendTextMessage(s);
                        }
                    } else break;
            }
    }

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
        ConsoleHelper.writeMessage("Port: ");
        while (true){
            result = ConsoleHelper.readInt();
            break;
        }
        return result;
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Client Name: ");
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
            ConsoleHelper.writeMessage("Connection aborted");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread{
        /**
         * должен выводить текст message в консоль.
         * @param message
         */
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        /**
         * должен выводить в консоль информацию о том,
         * что участник с именем userName присоединился к чату
         * @param userName
         */
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "joined the chat");
        }

        /**
         * должен выводить в консоль, что участник с именем userName покинул чат
         * @param userName
         */
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " left the chat");
        }

        /**
         * этот метод должен:
         *         а) Устанавливать значение поля clientConnected
         *         внешнего объекта Client в соответствии с переданным параметром.
         *         б) Оповещать (пробуждать ожидающий) основной поток класса Client.
         *
         *         Подсказка: используй синхронизацию на уровне текущего объекта
         *         внешнего класса и метод notify. Для класса SocketThread внешним классом
         *         является класс Client.
         * @param clientConnected
         */
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this){
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
    }
}
