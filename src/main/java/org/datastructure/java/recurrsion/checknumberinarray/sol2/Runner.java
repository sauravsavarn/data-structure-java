package org.datastructure.java.recurrsion.checknumberinarray.sol2;

import java.util.Scanner;

public class Runner {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter length of array : ");
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter item into array : ");
            input[i] = s.nextInt();
        }
        System.out.println("Enter element x to find in the array : ");
        int x = s.nextInt();
        System.out.println(CheckNumberInArray.checkNumber(input, 0, x));
    }
}
