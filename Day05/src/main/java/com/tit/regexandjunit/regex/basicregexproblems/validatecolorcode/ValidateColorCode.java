package com.tit.week04.day05.regex.basicregexproblems.validatecolorcode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateColorCode {
    public static boolean validateColorCode(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^#[A-Fa-f0-9]{6}$";
        System.out.print("Enter the Hex Code: ");
        while (true) {
            String string = input.next();
            if (string.equalsIgnoreCase("exit")) {
                break;
            }
            if (validateColorCode(regex, string)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            System.out.println("Enter exit to quit!");
        }
        input.close();
    }
}
