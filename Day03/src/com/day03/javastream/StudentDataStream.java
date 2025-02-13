package com.day03.javastream;

import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.details";

    public static void main(String[] args) {
        // Sample student data
        int rollNumber = 101;
        String name = "Anshu Priya";
        double gpa = 9.2;

        // Write data to file
        writeStudentData(rollNumber, name, gpa);

        // Read data from file
        readStudentData();
    }

    // Method to write student data to a binary file
    private static void writeStudentData(int roll, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    // Method to read student data from a binary file
    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
