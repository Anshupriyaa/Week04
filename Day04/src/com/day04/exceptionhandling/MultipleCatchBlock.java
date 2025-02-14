package com.day04.exceptionhandling;

import java.util.*;

public class MultipleCatchBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept the size of the array
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            // loop for getting  array elements
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Accept the index number to retrieve value
            System.out.print("Enter the index to retrieve value: ");
            int index = scanner.nextInt();

            // Print the value at the given index
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle case when index is out of bounds
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handle case when array is null
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            // Handle case when input is not an integer
            System.out.println("Invalid input! Please enter numbers only.");
        } finally {
            scanner.close();
        }
    }
}