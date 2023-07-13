package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {

    public String createFile(String fileName) {

        Path newFile;
        try {
            newFile = Files.createFile(Path.of(Constants.BASE_PATH + fileName + ".txt"));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return newFile + " created!";
    }

    public String writeToFile(String fileName, String content) {

        Path path = Paths.get(Constants.BASE_PATH + fileName + ".txt");

        try {
            if (!(Files.exists(path))) {
                System.out.println("There is no file " + fileName +
                        " in folder " + Constants.BASE_PATH);
                throw new IllegalArgumentException("File not found!");
            }
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in: " + path;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
