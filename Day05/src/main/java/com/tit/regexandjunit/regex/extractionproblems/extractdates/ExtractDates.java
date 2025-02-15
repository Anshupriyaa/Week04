package com.tit.week04.day05.regex.extractionproblems.extractdates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {
    public static void extractDates(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }
        if (!found) {
            System.out.println("No Dates found.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        System.out.print("Enter the text: ");
        String string = input.nextLine();

        extractDates(regex, string);
        input.close();
    }
}


