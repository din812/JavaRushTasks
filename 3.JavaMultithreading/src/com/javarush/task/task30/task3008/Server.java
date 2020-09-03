package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
                System.out.println("Сервер запущен.");
                while (true) {
                    new Handler(serverSocket.accept()).start();
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка. Сервер выключен.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) {
            try {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message incMessage = connection.receive();
                if (incMessage.getType() == MessageType.USER_NAME) {

                    String incUserName = incMessage.getData();

                    while (incUserName == null | incUserName.equals("")) {
                        connection.send(new Message(MessageType.NAME_REQUEST));
                        incMessage = connection.receive();
                        if (incMessage.getType() == MessageType.USER_NAME) {
                            incUserName = incMessage.getData();
                        }
                    }
                    if (!connectionMap.containsKey(incUserName) & incUserName != null) {
                        connectionMap.put(incUserName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return incUserName;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                serverHandshake(connection);
            }
            return serverHandshake(connection);
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == (MessageType.TEXT)) {
                    String userText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, userText));

                } else {
                    ConsoleHelper.writeMessage("Неверный формат сообщения");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Соединение с удаленным сервером установленно " + socket.getRemoteSocketAddress());
            Connection newConnection;
            String newUser = null;
            try {
                newConnection = new Connection(socket);
                newUser = serverHandshake(newConnection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser)); // сообщаем всем в чате о новом юзере
                notifyUsers(newConnection, newUser);    // говорим юзеру кто есть в чате
                serverMainLoop(newConnection, newUser); // главный цикл обработки сообщений
                socket.close();
                newConnection.close();
                connectionMap.remove(newUser);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error");
                e.printStackTrace();
            }
        }
    }
    
    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Ошибка при отправке сообщения.");
            }
        }
    }
}


