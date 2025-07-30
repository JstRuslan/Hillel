package HW10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files"+ File.separator;

    public String writeFile(String fileName, String fileContent){
        try(FileWriter fw = new FileWriter(BASE_PATH+fileName+".txt")) {
           fw.append(fileContent);
           return "Success.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing.";
        }
    }

    public String readFile(String fileName) {
        try (FileReader reader = new FileReader(BASE_PATH+fileName+".txt")) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
