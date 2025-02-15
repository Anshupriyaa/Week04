package com.tit.week04.day05.regex.advancedproblems.validateipaddress;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static boolean validateIPAddress(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?|0)(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?|0)){3}$";
        System.out.print("Enter a IPV4 Address: ");
        while (true) {
            String string = input.next();
            if (string.equalsIgnoreCase("exit")) {
                break;
            }
            if (validateIPAddress(regex, string)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            System.out.println("Enter exit to quit!");
        }
        input.close();
    }
}