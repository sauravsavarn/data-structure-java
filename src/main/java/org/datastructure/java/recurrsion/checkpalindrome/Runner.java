package org.datastructure.java.recurrsion.checkpalindrome;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to check for the Palindrome : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(isStringPalindrome(input));
    }

    public static boolean isStringPalindrome(String input) {
        // Write your code here
        if(input.length() == 0)
            return true;
        if(input.length() == 1)
            return false;
        if(input.charAt(0) != input.charAt(input.length()-1))
            return false;

        boolean output = true;
        if( (input.substring(1, input.length()-1)).length() != 1 )
            output = true && isStringPalindrome(input.substring(1, input.length()-1));
        return output;
    }
}
