package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("Участник с именем %s покинул чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {

            Client.this.clientConnected = clientConnected;

            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message incMessage = connection.receive();
                if (incMessage.getType() == MessageType.NAME_REQUEST) {
                    String newUserName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, newUserName));
                } else if (incMessage.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message serverMessage = connection.receive();
                if (serverMessage.getType() == MessageType.TEXT) {
                    processIncomingMessage(serverMessage.getData());
                } else if (serverMessage.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(serverMessage.getData());
                } else if (serverMessage.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(serverMessage.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        @Override
        public void run() {
            String host = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(host, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter server address:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка во время отправки сообщения");
            clientConnected = false;
            e.printStackTrace();
        }
    }

    public void run() {
        SocketThread daemonThread = getSocketThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            synchronized (this) {
                    wait();
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено.\n" +
                        "Для выхода наберите команду 'exit'.");
                while (clientConnected) {
                    String text = ConsoleHelper.readString();
                    if (text.equals("exit")) {
                        break;
                    } else if (shouldSendTextFromConsole()) {
                        sendTextMessage(text);
                    }
                }
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }

        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка, приложение закрывается.");
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
