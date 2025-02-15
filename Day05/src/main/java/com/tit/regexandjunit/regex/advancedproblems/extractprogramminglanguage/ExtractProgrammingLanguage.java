package com.tit.week04.day05.regex.advancedproblems.extractprogramminglanguage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguage {
    public static void extractProgrammingLanguage(String input, ArrayList<String> programmingLanguages) {
        String regex = "\\b(?i)(" + String.join("|", programmingLanguages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }

        if (!found) {
            System.out.println("No Programming Language found.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> programmingLanguages = new ArrayList<>(List.of("Java", "Python", "JavaScript", "Go", "Ruby"));
        System.out.print("Enter the text: ");
        String string = input.nextLine();

        extractProgrammingLanguage(string, programmingLanguages);
        input.close();
    }
}
