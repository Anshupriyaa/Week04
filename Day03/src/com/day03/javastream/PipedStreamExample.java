package com.day03.javastream;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void run() {
        try {
            String message = "Hello, A very happy goodMorning from Anshu";
            outputStream.write(message.getBytes()); // Convert string to byte array
            outputStream.close(); // Close after writing
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;

    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void run() {
        try {
            int data;
            System.out.print("Reader received: ");
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data); // Read byte and convert to char
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream); // Connect pipes

            // Create and start threads
            WriterThread writer = new WriterThread(outputStream);
            ReaderThread reader = new ReaderThread(inputStream);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Pipe Connection Error: " + e.getMessage());
        }
    }
}
