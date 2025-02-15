package com.tit.week04.day05.regex.basicregexproblems.validateusername;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {
    public static boolean validateUserName(String regex , String input){
        Pattern pattern = Pattern.compile(regex);

        Matcher  matcher = pattern.matcher(input);

        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        System.out.print("Enter the UserName: ");
        while(true){
            String string = input.next();
            if(string.equalsIgnoreCase("exit")){
               break;
            }
            if(validateUserName(regex,string)){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
            System.out.println("Enter exit to quit!");
        }
        input.close();
   }
}