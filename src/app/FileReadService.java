package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {

    public String readFromFile(String fileName) {
        Path path = Paths.get(Constants.BASE_PATH + fileName + ".txt");
        try {
            if (!(Files.exists(path))) {
                System.out.println("There is no file " + fileName +
                        " in folder " + Constants.BASE_PATH);
                throw new IllegalArgumentException("File not found!");
            }
            return Files.readString(path) + '\n' + "Read from: " + path;
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}