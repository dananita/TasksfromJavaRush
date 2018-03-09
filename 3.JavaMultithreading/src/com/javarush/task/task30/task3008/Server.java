package com.javarush.task.task30.task3008;

/**
 * @author Daria Zhuravel
 * @date 09.03.18
 **/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Основной класс сервера
 */
public class Server {
    private  static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();

    /**
     * отправляет сообщение всем соединениям из connectionMap
     * @param message
     */
    public static void sendBroadcastMessage(Message message){

        Iterator<String> ite = connectionMap.keySet().iterator();
        while(ite.hasNext()){
            String key = ite.next();
            Connection connectionWithClient = connectionMap.get(key);
            try {
                connectionWithClient.send(message);
            } catch (IOException e) {
                System.out.println("Don't worry, but The message is not send");
            }
        }
    }

    public static void main(String[] args) {
        int portSocket = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(portSocket);
                Socket fromClient;
                System.out.println("Server running");
                while(true) {
                    fromClient = serverSocket.accept();
                    Handler handler = new Handler(fromClient);
                    handler.start();
                }
            } catch (IOException e) {
                System.out.println("ServerSocket has an error!"+ e.getMessage());
                try {
                    if (serverSocket != null && !serverSocket.isClosed()) {
                        serverSocket.close();
                    }
                } catch (IOException e1) {
                    //* NOP
                }
            }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
