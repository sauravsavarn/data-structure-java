package org.datastructure.java.recurrsion.sumofdigits;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to calculate sum of digits : ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(sumOfDigits(n));
    }

    public static int sumOfDigits(int input) {
        if(input>=0 && input <= 9)
            return input;

        int output = Integer.parseInt((""+input).substring(0,1)) + sumOfDigits(Integer.parseInt((""+input).substring(1)));
        return output;
    }
}
