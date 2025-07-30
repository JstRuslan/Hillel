package HW11;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        File newFile;
        try {
            newFile = Files.createFile(Path.of(path)).toFile();
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(String path, String content) {
        try {
            Files.writeString(Path.of(path), content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}
