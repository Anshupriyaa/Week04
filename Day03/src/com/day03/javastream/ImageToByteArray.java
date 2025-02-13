package com.day03.javastream;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\input.jpg";   // Replace with your image file
        String outputImagePath = "output.jpg"; // New file to be created

        try {
            // Convert image to byte array
            byte[] imageBytes = readImageToByteArray(inputImagePath);
            System.out.println("Image converted to byte array successfully!");

            // Write byte array back to image file
            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array written back to image file successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Reads an image file and converts it to a byte array
    private static byte[] readImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // Read in chunks of 4 KB
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray(); // Return byte array
        }
    }

    // Writes a byte array to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
             FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096]; // Write in chunks of 4 KB
            int bytesRead;

            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}