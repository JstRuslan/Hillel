package org.summer2025.ruslan.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.summer2025.ruslan.myServer.Server;
import org.summer2025.ruslan.myServer.models.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static org.slf4j.LoggerFactory.getLogger;

public class ClientApp {
    private static final Logger logger = LoggerFactory.getLogger(ClientApp.class);
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8186;

    public static void main(String[] args) throws InterruptedException {
        ClientApp clientApp = new ClientApp();
        clientApp.connected();
        while (true) {

        }
    }

    public void connected() {
        try {
            Socket socket = new Socket(DEFAULT_HOST, DEFAULT_PORT);
            waitMsg(socket);
            readCMD(socket);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Connection is absent");
        }
    }

    public void waitMsg(Socket socket) {
        Thread threadWaitMsg = new Thread(() -> {
            try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    if (!socket.isClosed() && socket.isConnected()) {
                        String msg = in.readUTF();
                        if (msg != null) {
                            if (msg.startsWith(Command.SERVER_MSG_CMD_PREFIX)) {
                                logger.info("> {}", msg);
                            }

                        }
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        threadWaitMsg.setDaemon(true);
        threadWaitMsg.start();
    }

    public void readCMD(Socket socket) throws IOException {
        Thread threadReadCMD = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in);
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    String msg = scanner.nextLine();
                    if (msg != null) {
                        sendMsg(socket, out, msg);
                    }
                    if (msg.startsWith(Command.EXIT_CLIENT_CMD_PREFIX)) {
                        socket.close();
                        logger.info("Connection is close");
                        System.exit(2);
                        break;
                    }
                }
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        });
        threadReadCMD.setDaemon(true);
        threadReadCMD.start();
    }

    public void sendMsg(Socket socket, DataOutputStream out, String msg) {

        try {
            if (socket == null) {
                throw new IOException();
            }
            out.writeUTF(msg);
            logger.info("Message send!");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Message doesn`t send!");
        }
    }

}