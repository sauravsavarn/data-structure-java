package org.datastructure.java.recurrsion.indexofnumber.lastindex;

import java.util.Scanner;

public class Runner {

    static Scanner s = new Scanner(System.in);

    public static int[] takeInput() {
        System.out.println("Enter size of an array : ");
        int size = s.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element x into array : ");
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        System.out.println("Enter a number to check first-index of : ");
        int x = s.nextInt();
        System.out.println(CheckIndexOfNumInArray.lastIndex(input, x));
    }
}
