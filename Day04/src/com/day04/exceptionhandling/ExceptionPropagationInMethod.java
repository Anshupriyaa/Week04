package com.day04.exceptionhandling;
class ExceptionPropagationInMethod {
    // Method that throws an exception
    public static void method1() {
        throw new ArithmeticException("Division by zero");
    }

    // Method that calls method1()
    public static void method2() {
        method1();
    }

    // Main method that calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

