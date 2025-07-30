package HW11;

import java.io.File;

public class FileApp {

    private static final String BASE_PATH = "files" + File.separator;

    public static void main(String[] args) {

        FileHandler handler = new FileHandler();
        String newFileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + newFileName + ".txt";
        // Виклики методів маніпуляції з файлом
        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(path, content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}