package com.tit.week04.day05.regex.replaceandmodifyproblems.replacemultiplespaces;

import java.util.Scanner;

public class ReplaceMultipleSpaces {
    public static String replaceMultipleSpaces(String input){
        input = input.replaceAll("\\s+"," ");
        return input;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String string = input.nextLine();

        String modifiedString = replaceMultipleSpaces(string);
        System.out.println("Original String : " + string);
        System.out.println("Modified String : " + modifiedString);
        input.close();
    }
}

