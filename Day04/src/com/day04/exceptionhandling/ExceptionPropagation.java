package com.day04.exceptionhandling;
class ExceptionPropagation {
    // Method that propagates the exception using throws
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            // Valid case
            double interest = calculateInterest(10000, 5, 2);
            System.out.println("Calculated Interest: " + interest);

            // Invalid case (Exception should be thrown)
            double invalidInterest = calculateInterest(-5000, 4, 3);
            System.out.println("Calculated Interest: " + invalidInterest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}