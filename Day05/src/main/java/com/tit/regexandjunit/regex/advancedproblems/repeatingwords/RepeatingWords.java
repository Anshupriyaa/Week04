package com.tit.week04.day05.regex.advancedproblems.repeatingwords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {
    public static void repeatingWords(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group(1) + ", ");
            found = true;
        }
        if (!found) {
            System.out.println("No Repeating Words found.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\b(\\w+)(\\s+\\1)\\b";

        System.out.print("Enter the text: ");
        String string = input.nextLine();

        repeatingWords(regex, string);
        input.close();
    }
}

