package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;

/**
 * @author Daria Zhuravel
 * @date 11.03.18
 **/
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread{

    }
}
