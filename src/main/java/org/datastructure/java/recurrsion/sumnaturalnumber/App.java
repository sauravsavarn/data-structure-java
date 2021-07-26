package org.datastructure.java.recurrsion.sumnaturalnumber;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Enter a num to calculate SUM of : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        NaturalNumbers naturalNumbers = new NaturalNumbers();

        /* ** now using concept of PMI, calculating ** */
        int naturalNos = naturalNumbers.calculateUsingRecurrsion(input);

        System.out.println("∑"+input + " = " + naturalNos);
    }
}
