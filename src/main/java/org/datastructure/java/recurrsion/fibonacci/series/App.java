package org.datastructure.java.recurrsion.fibonacci.series;

import java.util.Scanner;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Enter a limit to print Fibonacci Series : ");
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();

        /* ** now proceed to print Fibonacci Series of limit 'limit' ** */
        for (int i = 0; i < limit ; i++) {
            System.out.print(FibonacciSeries.genSeries(i) + " e");
        }
    }
}

/**
 *
 */
class FibonacciSeries {
    public static int genSeries(int num) {
        if( num == 0)
            return 0;
        if(num == 1)
            return 1;

        int output = genSeries(num-1)+genSeries(num-2);
        return output;
    }

}
