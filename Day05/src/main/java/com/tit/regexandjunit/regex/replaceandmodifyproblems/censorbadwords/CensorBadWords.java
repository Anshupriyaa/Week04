package com.tit.week04.day05.regex.replaceandmodifyproblems.censorbadwords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CensorBadWords {
    public static String censorBadWords(String input,ArrayList<String> badWords){
        for(String badWord: badWords){
            String replaceWord = ("*").repeat(badWord.length());
            input = input.replaceAll("(?i)\\b" + badWord + "\\b",replaceWord);
        }

        return input;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String string = input.nextLine();
        ArrayList<String> badWords = new ArrayList<>(List.of("damn","stupid"));

        String modifiedString = censorBadWords(string,badWords);
        System.out.println("Original String : " + string);
        System.out.println("Modified String : " + modifiedString);
        input.close();
    }
}
