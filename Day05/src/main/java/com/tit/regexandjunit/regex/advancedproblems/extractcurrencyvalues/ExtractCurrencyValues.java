package com.tit.week04.day05.regex.advancedproblems.extractcurrencyvalues;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValues {
    public static void extractCurrencyValues(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }
        if (!found) {
            System.out.println("No Currency Value found.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\$?\\d+\\.\\d{2}";

        System.out.print("Enter the text: ");
        String string = input.nextLine();

        extractCurrencyValues(regex, string);
        input.close();
    }
}

