package org.datastructure.java.recurrsion.multiplication;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter a string to calculate multiplication using addition/substraction : ");
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println(multiplyTwoIntegers(m, n));
    }

    public static int multiplyTwoIntegers(int m, int n){
        if(n==0)
            return 0;

        int output = m + multiplyTwoIntegers(m, n-1);
        return output;
    }
}
