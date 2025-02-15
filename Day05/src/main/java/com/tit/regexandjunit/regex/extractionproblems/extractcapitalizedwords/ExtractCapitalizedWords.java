package com.tit.week04.day05.regex.extractionproblems.extractcapitalizedwords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCapitalizedWords {
    public static void extractCapitalizedWords(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }
        if (!found) {
            System.out.println("No capitalized words found.");
        } else {
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\b[A-Z][a-z]*\\b";

        System.out.print("Enter the text: ");
        String string = input.nextLine();

        extractCapitalizedWords(regex, string);
        input.close();
    }
}

