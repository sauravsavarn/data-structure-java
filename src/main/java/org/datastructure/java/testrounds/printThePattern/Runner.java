package org.datastructure.java.testrounds.printThePattern;

import java.util.Scanner;
public class Runner {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        Solution.printPattern(n);

    }
}
