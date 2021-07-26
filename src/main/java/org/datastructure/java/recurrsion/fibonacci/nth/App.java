package org.datastructure.java.recurrsion.fibonacci.nth;

import java.util.Scanner;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Enter a number to find nth Fibonacci Series Number : ");
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        System.out.println(FibonacciSeries.genSeries(limit));
    }
}
class FibonacciSeries {
    public static int genSeries(int num) {
       if(num  == 2 || num == 1)
            return 1;

        int fib_n_1 = genSeries(num - 1);
        int fib_n_2 = genSeries(num - 2);
        int output =  fib_n_1 + fib_n_2;

        return output;
    }

}
