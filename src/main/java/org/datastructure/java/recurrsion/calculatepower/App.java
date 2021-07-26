package org.datastructure.java.recurrsion.calculatepower;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Enter 2 input to calculate power of number : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        /* ** ** */
        CalculatePower calculatePower = new CalculatePower(x, n);

        System.out.println(x+"^"+n + " = " + calculatePower.calculatePower(x,n));
    }
}
