package com.day04.exceptionhandling;
import java.io.*;

public class ReadFileWithResources {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "info.txt";

        // Try-with-resources to ensure automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read and print the first line of the file
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            }
        } catch (IOException e) {
            // Handle the exception if the file is not found or cannot be read
            System.out.println("Error reading file");
        }
    }
}
