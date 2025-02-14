package com.day04.exceptionhandling;

import java.util.*;

// Custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("You can vote21!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            //method call
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Handle custom exception
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("Error: Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
