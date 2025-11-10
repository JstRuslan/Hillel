package org.summer2025.ruslan.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoad {
    private static final Properties DB_CONFIG = new Properties();

static {
loadConfigDB();
}

private ConfigLoad() {
}

    private static void loadConfigDB() {
        InputStream inStream=ConfigLoad.class.getClassLoader().getResourceAsStream("configs/DB.properties");
        try {
            DB_CONFIG.load(inStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key){
        return DB_CONFIG.getProperty(key);
    }
}
