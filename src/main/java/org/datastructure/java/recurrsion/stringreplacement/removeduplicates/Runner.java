package org.datastructure.java.recurrsion.stringreplacement.removeduplicates;

import java.util.Scanner;

/**
 * Write a program to replace character(s) in an String by some another character.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string where to replace occurance of 'x' : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(removeConsecutiveDuplicates(input));
    }

    // Return the final string having all consecutive duplicates removed.
    public static String removeConsecutiveDuplicates(String input) {
        // Write your code here
        if (input.length() == 1)
            return input;

        if (input.charAt(0) == input.charAt(1))
            return removeConsecutiveDuplicates(input.substring(1));
        else
            return input.charAt(0) + removeConsecutiveDuplicates(input.substring(1));

    }
}