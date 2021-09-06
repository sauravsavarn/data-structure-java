package org.datastructure.java.testrounds.pangram;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int n;
        n = s.nextInt();
        s.nextLine();
        str = s.nextLine();
        Solution.ans(n,str);
    }
}
