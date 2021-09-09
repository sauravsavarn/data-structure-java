package org.datastructure.java.recurrsion.printKeypadCode;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        //Solution1.printKeypad(input);
        //Solution2.printKeypad(input);
        Solution3.printKeypad(input);
    }
}
