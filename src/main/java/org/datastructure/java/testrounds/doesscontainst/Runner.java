package org.datastructure.java.testrounds.doesscontainst;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String large = s.nextLine();
        String small = s.nextLine();

        System.out.println(Solution3.checkSequence(large, small));
    }
}
