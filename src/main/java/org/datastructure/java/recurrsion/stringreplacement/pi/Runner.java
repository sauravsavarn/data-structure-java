package org.datastructure.java.recurrsion.stringreplacement.pi;

import java.util.Scanner;

/**
 * Write a program to replace 'pi' with 3.14 where-ever 'pi' exists.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string where to replace occurance of 'pi' with '3.14' : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(replacePI(input));
    }

    // Return the changed string
    public static String replacePI(String input){

        if(input.length() == 1) {
            return input;
        }

        if( input.substring(0,2).equalsIgnoreCase("PI") )
            return "3.14"+replacePI(input.substring(2));
        else
            return input.substring(0,1) + replacePI(input.substring(1));
            //return input.substring(0,1) + replacePI(input.substring(1));

    }
}