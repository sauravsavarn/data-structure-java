package org.datastructure.java.recurrsion.stringreplacement.generic;

import java.util.Scanner;

/**
 * Write a program to replace character(s) in an String by some another character.
 */
public class Runner {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Please enter a string to be replaced : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        System.out.println("Enter a character to be replaced using recurrsion : ");
        char inputChar = scanner.next().charAt(0);

        System.out.println("Enter a character replaced with : ");
        char replacedByChar = scanner.next().charAt(0);

        System.out.println("Final String : " + replaceChar(inputString, inputChar, replacedByChar));
    }

    /**
     *
     * @param inputString
     * @param replaceableChar
     * @param replacedByChar
     * @return
     */
    private static String replaceChar(String inputString, char replaceableChar, char replacedByChar) {
        if( inputString.length() == 1)
            return inputString;

        String outputString = replaceChar(inputString.substring(1, inputString.length()), replaceableChar, replacedByChar);
        if(inputString.charAt(0) == replaceableChar)
            return replacedByChar + outputString;
        else
            return inputString.charAt(0) + outputString;
    }
}