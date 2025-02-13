package com.day03.javastream;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\source.txt  ";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {  // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
