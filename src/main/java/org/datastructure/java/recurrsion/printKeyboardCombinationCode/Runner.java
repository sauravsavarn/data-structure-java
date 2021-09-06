package org.datastructure.java.recurrsion.printKeyboardCombinationCode;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        Solution.printKeypad(input);
    }
}
