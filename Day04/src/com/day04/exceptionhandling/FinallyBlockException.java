package com.day04.exceptionhandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlockException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking two integers from the user
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Performing division
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }catch(InputMismatchException e){
            System.out.print("Error: Please enter valid numeric values.");
        }
            finally {
            // This block will always execute
            System.out.println("Operation completed.");
            scanner.close(); // Closing scanner to prevent resource leak
        }
    }
}
