package com.tit.regexandjunit.junit.filehandling;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileHandling {

    public void writeToFile(String filename, String content) throws IOException {
        Path filePath = Path.of(filename);
        Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public String readFromFile(String filename) throws IOException {
        Path filePath = Path.of(filename);
        return Files.readString(filePath);
    }
}
