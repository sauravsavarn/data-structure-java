package org.datastructure.java.recurrsion.printPermutationsOfAString;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Solution.permutations(input);
    }
}
