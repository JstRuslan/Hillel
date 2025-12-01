package org.summer2025.ruslan.myServer;

import java.io.IOException;

public class ServerApp {
    public static final int DEFAULT_PORT = 8186;

    public static void main(String[] args) {

        new Server().start(DEFAULT_PORT);

    }
}
