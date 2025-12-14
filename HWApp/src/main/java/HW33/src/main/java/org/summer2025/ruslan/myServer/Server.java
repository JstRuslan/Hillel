package org.summer2025.ruslan.myServer;

import org.slf4j.Logger;
import org.summer2025.ruslan.myServer.handler.ClientHandler;
import org.summer2025.ruslan.myServer.models.Command;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.slf4j.LoggerFactory.getLogger;

public class Server {
    private static final Logger logger = getLogger(Server.class);
    private static final AtomicInteger clientCounter = new AtomicInteger(1);
    private ServerSocket serverSocket;
    private String connectTime;
    private Socket socket;
    private final List<ClientHandler> clients;

    public Server() {
        clients = new ArrayList<>();
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            this.serverSocket = serverSocket;
            logger.info("Server is started");
            while (true) {
                waitNewClientConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitNewClientConnection() throws IOException {
        logger.info("Wait a client");
        socket = serverSocket.accept();
        processClientConnection(socket);
    }

    private void processClientConnection(Socket socket) throws IOException {
        String clientName = "client-" + clientCounter.getAndIncrement();
        String connectTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ClientHandler handler = new ClientHandler(this, socket, clientName, connectTime);
        subscribe(handler);
        handler.handle();
    }

    public synchronized void subscribe(ClientHandler clientHandler) throws IOException {
        clients.add(clientHandler);
        logger.info("{} {} is connected", Command.SERVER_MSG_CMD_PREFIX, clientHandler.getUsername());
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) throws IOException {
        clients.remove(clientHandler);
        logger.info("{} {} is disconnected", Command.SERVER_MSG_CMD_PREFIX, clientHandler.getUsername());
    }
}
