package com.day04.exceptionhandling;
class NestedTryCatchExample {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int index = 5; // this will throw array out of bound exception
        int divisor = 0;

        try {
            int value = array[index]; // May throw ArrayIndexOutOfBoundsException
            try {
                int result = value / divisor; // May throw ArithmeticException
                System.out.println("Division Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}

