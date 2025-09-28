package HW24;

public class LoggerApp {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Start app");

        logger.log("App is working");

        Logger logger2 = Logger.getInstance();
        logger2.log("App finished work");

    }
}
