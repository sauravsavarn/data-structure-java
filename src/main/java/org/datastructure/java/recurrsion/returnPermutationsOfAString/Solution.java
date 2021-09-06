package org.datastructure.java.recurrsion.returnPermutationsOfAString;

import java.util.Vector;

public class Solution {
    static Vector<String> vector = new Vector<>();

    public static String[] permutationOfString(String input) {
        // Write your code here
        permutation(input, 0, input.length() - 1);

        String[] output = new String[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            output[i] = vector.get(i);
        }

        return output;
    }

    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private static void permutation(String str, int l, int r) {
        if (l == r) {
            vector.add(str);
            //System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutation(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
