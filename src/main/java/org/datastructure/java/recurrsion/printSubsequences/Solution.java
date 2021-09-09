package org.datastructure.java.recurrsion.printSubsequences;

public class Solution {

    public static void printSubsequences(String word) {
        printSubsequences(word, "");
    }

    public static void printSubsequences(String input, String subsequences) {
        ////base case
        if (input.length() == 0) {
            ////////use to print all subsequences so far
            System.out.print(subsequences);
            return;
        }

        String smallerInput = input.substring(1);
        printSubsequences(smallerInput, subsequences); /////without
        printSubsequences(smallerInput, " " + subsequences + input.charAt(0));
    }

}
