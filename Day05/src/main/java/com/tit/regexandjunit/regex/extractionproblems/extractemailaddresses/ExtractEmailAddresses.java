package com.tit.week04.day05.regex.extractionproblems.extractemailaddresses;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailAddresses {
    public static void extractEmailAddress(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println("Found Email : " + matcher.group());
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

        System.out.print("Enter the text : ");
        String string = input.nextLine();

        extractEmailAddress(regex,string);
        input.close();
    }
}
