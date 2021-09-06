package org.datastructure.java.testrounds.pyramidNumberPattern;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printPyramid(num);
    }

    private static void printPyramid(int level) {
        for (int i = 0; i < level; i++) {
            /////////creating pre-space
            for (int j = i; j < level-1; j++) {
                System.out.print(" ");
            }
            for (int j = i+1; j >=1 ; j--) {
                System.out.print(j);
            }
            //////print other half
            if(i!=0) {
                for (int k = 2; k <= (i+1); k++) {
                    System.out.print(k);
                }
            }
            System.out.println("");
        }
    }
}
