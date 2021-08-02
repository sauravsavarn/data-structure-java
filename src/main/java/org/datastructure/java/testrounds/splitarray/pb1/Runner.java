package org.datastructure.java.testrounds.splitarray.pb1;

import java.util.Scanner;

public class Runner {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter size of array : ");
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter Item(s) in array : ");
            input[i] = s.nextInt();
        }
        System.out.println(Solution1.splitArray(input));
    }
}
