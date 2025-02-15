package com.tit.week04.day05.regex.advancedproblems.validatesecuritynumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSecurityNumber {
    public static String extractSecurityNumber(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        System.out.print("Enter a text containing Social Security Number: ");
        while (true) {
            String string = input.nextLine();
            if (string.equalsIgnoreCase("exit")) {
                break;
            }

            String ssn = extractSecurityNumber(regex, string);
            if (ssn != null) {
                System.out.println(ssn  + " is valid");
            } else {
                System.out.println("Invalid SSN");
            }

            System.out.println("Enter exit to quit!");
        }
        input.close();
    }
}
