package com.tit.week04.day05.regex.basicregexproblems.validatelicenseplatenumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlate {
    public static boolean validateLicensePlate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^[A-Z]{2}\\d{4}$";
        System.out.print("Enter the License Plate Number: ");
        while (true) {
            String string = input.next();
            if (string.equalsIgnoreCase("exit")) {
                break;
            }
            if (validateLicensePlate(regex, string)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            System.out.println("Enter exit to quit!");
        }
        input.close();
    }
}