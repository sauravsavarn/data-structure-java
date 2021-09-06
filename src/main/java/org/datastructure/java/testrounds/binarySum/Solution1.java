package org.datastructure.java.testrounds.binarySum;

import java.util.Scanner;

public class Solution1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            String str1 = sc.next();
            String str2 = sc.next();

            // Write your code here
            if(!str1.isEmpty() && !str2.isEmpty())
                System.out.println(addBinary(str1, str2));
            else if(!str1.isEmpty() && str2.isEmpty())
                System.out.println(str2);
            else
                System.out.println(str1);
        }
    }

    static String addBinaryString(String binaryNumber1, String binaryNumber2) {
        // converting strings into binary format numbers
        Integer integer1 = Integer.parseInt(binaryNumber1, 2);
        Integer integer2 = Integer.parseInt(binaryNumber2, 2);

        // adding two integers
        Integer output = integer1 + integer2;

        // converting final output back to Binary Integer
        return Integer.toBinaryString(output);
    }

    // This function adds two
    // binary strings and return
    // result as a third string
    static String addBinary(String a, String b) {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char) (s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }

        return result;
    }
}
