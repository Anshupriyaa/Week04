package com.day03.javastream;

import java.io.*;

public class BufferedStreams {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";    // Replace with actual file path
        String destinationBuffered = "buffered_copy.txt";
        String destinationUnbuffered = "unbuffered_copy.txt";

        // Measure execution time for Buffered Streams
        long startBuffered = System.nanoTime();
        copyFileWithBufferedStreams(sourceFile, destinationBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Streams Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        // Measure execution time for Unbuffered Streams
        long startUnbuffered = System.nanoTime();
        copyFileWithUnbufferedStreams(sourceFile, destinationUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Streams Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }

    // Copy File using Buffered Streams (Efficient)
    private static void copyFileWithBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("Buffered file copy completed!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //  Copy File using Unbuffered Streams (Slower)
    private static void copyFileWithUnbufferedStreams(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("Unbuffered file copy completed!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}