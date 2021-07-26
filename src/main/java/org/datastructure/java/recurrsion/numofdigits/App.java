package org.datastructure.java.recurrsion.numofdigits;

import org.datastructure.java.recurrsion.calculatepower.CalculatePower;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Enter a number to calculate number of digits this contains : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        /* ** ** */
        System.out.println("Total number of digits in " + number + " = " + Solution.count(number));
    }
}

/**
 *
 */
class Solution {
    /**
     * @param n
     * @return
     */
    public static int count(int n) {
        if(n==0)
            return 0;
        if (n==1)
            return 1;
        int smallAns = 1 + count( n/10 );
        return smallAns;
    }
}
