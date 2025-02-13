package com.day03.javastream;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Move to the next line
            }

            System.out.println("Conversion completed! Check output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}