package org.datastructure.java.testrounds.maxprofitonapp;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i=0;i<n;i++)
            input[i] = s.nextInt();

        System.out.println(Solution.maximumProfit(input));
    }
}
