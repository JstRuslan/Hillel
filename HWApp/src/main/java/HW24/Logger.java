package HW24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    private static final Path LOG_PATH = Path.of("HWApp","src","main", "java", "HW24", "Logs", "log.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        try {
            if (Files.notExists(LOG_PATH)) {
                Files.createDirectories(LOG_PATH.getParent());
                Files.createFile(LOG_PATH);
                System.out.println(">Log file created: " + LOG_PATH.toAbsolutePath());
            } else {
                System.out.println(">The log file is already exists.");
            }
        } catch (IOException e) {
            System.err.println(">Error creating log file: " + e.getMessage());
        }
        System.out.println(">Singleton instance created");
    }

    public static Logger getInstance(){
        if(instance==null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg){
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String formattedMessage = String.format("[%s] - \"%s\"%n", timestamp, msg);

        try {
            Files.write(LOG_PATH, formattedMessage.getBytes(), StandardOpenOption.APPEND);
            System.out.println(">Writed log file");
        } catch (IOException e) {
            System.err.println(">Error writing log file: " + e.getMessage());
        }
    }
}
