package org.datastructure.java.recurrsion.pairstart;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to convert to Integer : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(addStars(input));
    }

    // Return the updated string
    public static String addStars(String s) {
        if(s.length()==1)
            return s;

        String temp1 = ""+s.charAt(0);
        String temp2 = addStars(s.substring(1));
        String output = temp1 + ( temp1.charAt(0) == temp2.charAt(0) ? ( "*" + temp2) : temp2 );

        return output;
    }
}
