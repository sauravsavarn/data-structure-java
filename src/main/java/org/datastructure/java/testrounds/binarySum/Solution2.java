package org.datastructure.java.testrounds.binarySum;

import java.util.Scanner;

public class Solution2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            StringBuilder str1 = new StringBuilder(sc.next());
            StringBuilder str2 = new StringBuilder(sc.next());

            // Write your code here
            if( str1.length()!=0 && str2.length()!=0)
                System.out.println(addBinaryString(str1, str2));
            else if(str1.length()==0 && str2.length()!=0)
                System.out.println(str2);
            else
                System.out.println(str1);
        }
    }

    static String addBinaryString(StringBuilder first, StringBuilder second) {
        String result = ""; // To store the sum bits

        // make the lengths same before adding
        int length = makeEqualLength(first, second);

        int carry = 0; // Initialize carry

        // Add all bits one by one
        for (int i = length - 1; i >= 0; i--)
        {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result = String.valueOf((char) sum) + result;

            // boolean expression for 3-bit addition
            carry = (firstBit & secondBit) |
                    (secondBit & carry) |
                    (firstBit & carry);
        }

        // if overflow, then add a leading 1
        if (carry == 1)
            result = "1" + result;
        return result;
    }


    // Helper method: given two unequal sized bit strings,
    // converts them to same length by adding leading 0s
    // in the smaller string. Returns the the new length
    // Using StringBuilder as Java only uses call by value
    static int makeEqualLength(StringBuilder str1,
                               StringBuilder str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2)
        {
            for (int i = 0; i < len2 - len1; i++)
                str1.insert(0, '0');
            return len2;
        }
        else if (len1 > len2)
        {
            for (int i = 0; i < len1 - len2; i++)
                str2.insert(0, '0');
        }

        return len1; // If len1 >= len2
    }
}
