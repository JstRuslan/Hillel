package org.summer2025.ruslan.myServer.models;

public class Command {
    public static final String CLIENT_MSG_CMD_PREFIX = "[USER] "; // + msg
    public static final String SERVER_MSG_CMD_PREFIX = "[SERVER] "; // + msg
    public static final String USERLIST_CMD_PREFIX = "/userlist"; // + userList from Server
    public static final String EXIT_CLIENT_CMD_PREFIX = "/exit";
}
