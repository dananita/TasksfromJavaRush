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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message nameClient = null;
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                nameClient = connection.receive();
                if (nameClient.getType() == MessageType.USER_NAME
                        && !nameClient.getData().isEmpty()
                        && !nameClient.getData().equals("")) {
                    if(!connectionMap.containsKey(nameClient.getData())) {
                        connectionMap.put(nameClient.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return nameClient.getData();
                    }
                }
            }
        }

        /**
         *
         * @param connection - соединение с участником, которому будет слать информацию
         * @param userName - имя участника, которому послали информацию
         */
        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> pairConnection: connectionMap.entrySet()) {
                if(!connection.equals(pairConnection) && !userName.equals(pairConnection.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, pairConnection.getKey()));
                }

            }
        }

        /**
         *
         * @param connection - соединение с участником, которому будет слать информацию
         * @param userName - имя участника, которому послали информацию
         */
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true){
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + receiveMessage.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }

        }
    }
}
