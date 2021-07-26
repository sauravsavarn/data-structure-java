package org.datastructure.java.recurrsion.factorial;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Enter a number to calculate Factorial of : ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(num+"! = " + factorial(num));
    }

    /**
     * Call function factorial to calculate Factorial of input number.
     *
     * @param input
     * @return
     */
    private static int factorial(int input) {
        if(input == 1)
            return input;

        int intermediateResults = factorial(input-1);
        int output = input * factorial(input-1);

        /* ** ** */
        return output;
    }
}
