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
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    /**
     * отправляет сообщение всем соединениям из connectionMap
     *
     * @param message
     */
    public static void sendBroadcastMessage(Message message) {
        Iterator<String> ite = connectionMap.keySet().iterator();
        while (ite.hasNext()) {
            String key = ite.next();
            Connection connectionWithClient = connectionMap.get(key);
            try {
                connectionWithClient.send(message);
            } catch (IOException e) {
                System.out.println("Don't worry, but The message was not sent");
            }
        }
    }

    public static void main(String[] args) {
        int portSocket = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portSocket);
            System.out.println("Server running");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("ServerSocket has an error!" + e.getMessage());
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e1) {
                //* NOP
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * аутентификация клиентов сервером
         * @param connection
         * @return  возвращает String "имя клиента" сервера
         * @throws IOException
         * @throws ClassNotFoundException
         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message nameClient = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                nameClient = connection.receive();
                if (nameClient.getType() == MessageType.USER_NAME
                        && !nameClient.getData().isEmpty()
                        && !nameClient.getData().equals("")) {
                    if (!connectionMap.containsKey(nameClient.getData())) {
                        connectionMap.put(nameClient.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return nameClient.getData();
                    }
                }
            }
        }

        /**
         * @param connection - соединение с участником, которому будет слать информацию
         * @param userName   - имя участника, которому послали информацию
         */
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pairConnection : connectionMap.entrySet()) {
                if (!connection.equals(pairConnection) && !userName.equals(pairConnection.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, pairConnection.getKey()));
                }

            }
        }

        /**
         * @param connection - соединение с участником, которому будет слать информацию
         * @param userName   - имя участника, которому послали информацию
         */
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + receiveMessage.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }

        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress()!= null) {
                ConsoleHelper.writeMessage("Established a new connection with " +
                        "a remote socket address: " + socket.getRemoteSocketAddress());
            }
            String nameNewClient = null;
            try (Connection connection = new Connection(socket)){
                nameNewClient= serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, nameNewClient));
                sendListOfUsers(connection,nameNewClient);
                serverMainLoop(connection,nameNewClient);

            } catch (IOException e) {
                ConsoleHelper.writeMessage("The error was happened when the data was sent to a remote addresses");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("The error was happened when the data was sent to a remote addresses!");
            } finally {
                if (nameNewClient != null){
                    connectionMap.remove(nameNewClient);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, nameNewClient));
                }
                ConsoleHelper.writeMessage("The connection with a remote address is terminated");
            }

        }
    }
}
