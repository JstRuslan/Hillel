package org.summer2025.ruslan.myServer.handler;

import org.summer2025.ruslan.myServer.Server;
import org.summer2025.ruslan.myServer.models.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private String connectTime;
    private final String username;
    private DataInputStream in;
    private DataOutputStream out;


    public ClientHandler(Server server, Socket socket, String username, String connectTime) {
        this.server = server;
        this.socket = socket;
        this.username = username;
        this.connectTime = connectTime;

          try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handle() throws IOException {
        readCMD(socket);
        new Thread(() -> {
            waitMsg();
            try {
                server.unSubscribe(this);
//                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void waitMsg() {
        while (true) {
            try {
                if (!socket.isClosed()) {
                    String msg = in.readUTF();
                    System.out.println(Command.CLIENT_MSG_CMD_PREFIX + username + "> " + msg);
                    if (msg.startsWith(Command.EXIT_CLIENT_CMD_PREFIX)) {
                        server.unSubscribe(this);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readCMD(Socket socket) {
        Thread threadReadCMD = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String msg = scanner.nextLine();
                    if (msg != null) {
                        sendServerMessage(msg);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadReadCMD.setDaemon(true);
        threadReadCMD.start();
    }

    public void sendServerMessage(String message) {
        try {
            out.writeUTF(String.format("%s: %s", Command.SERVER_MSG_CMD_PREFIX, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getUsername() {
        return username;
    }

    public String getConnectTime() {
        return connectTime;
    }

    public Socket getSocket() {
        return socket;
    }
}
