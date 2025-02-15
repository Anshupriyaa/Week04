package com.tit.week04.day05.regex.extractionproblems.extractlinks;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void extractLinks(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }
        if (!found) {
            System.out.println("No Links found.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-z]{2,}(/\\S*)?";
        System.out.print("Enter the text: ");
        String string = input.nextLine();

        extractLinks(regex, string);
        input.close();
    }
}