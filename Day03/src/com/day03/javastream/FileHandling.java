package com.day03.javastream;
import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        // Source and Destination File Paths
        String sourceFile = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\source.txt";
        String destinationFile = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\destination.txt";

        // File Handling with Streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData); // Write byte by byte
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found!");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred!");
        }
    }
}

