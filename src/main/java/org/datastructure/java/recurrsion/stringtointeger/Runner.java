package org.datastructure.java.recurrsion.stringtointeger;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to convert to Integer : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(convertStringToInt(input));
    }

    public static int convertStringToInt(String input){
        if(input.length() == 1)
            return Integer.parseInt(input);

        int output = ( Integer.parseInt(input.substring(0,1)) * (int) Math.pow(10, input.length()-1))   + convertStringToInt(input.substring(1));
        return output;
    }
}
