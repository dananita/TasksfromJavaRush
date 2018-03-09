package com.javarush.task.task30.task3008;

/**
 * @author Daria Zhuravel
 * @date 09.03.18
 **/

import java.io.IOException;
import java.net.Socket;

/**
 * Основной класс сервера
 */
public class Server {
    public static void main(String[] args) {
        try {
            Socket a = new Socket();
            Connection connection = new Connection(a);
            connection.send(new Message(MessageType.TEXT,"maria"));
            System.out.println(connection.receive().getData());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
