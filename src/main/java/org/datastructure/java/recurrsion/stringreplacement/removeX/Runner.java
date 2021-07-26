package org.datastructure.java.recurrsion.stringreplacement.removeX;

import java.util.Scanner;

/**
 * Write a program to replace character(s) in an String by some another character.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string where to replace occurance of 'x' : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(removeX(input));
    }

    // Return the changed string
    public static String removeX(String input){
        // Write your code here
        if(input.length() == 1) {
            if(input.charAt(0)=='x')
                return "";
            else
                return input;
        }

        String outputString = removeX(input.substring(1));

        if( input.charAt(0) == 'x' )
            return outputString;
        else
            return input.charAt(0) + outputString;

    }
}