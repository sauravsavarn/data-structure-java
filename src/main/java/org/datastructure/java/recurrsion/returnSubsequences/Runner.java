package org.datastructure.java.recurrsion.returnSubsequences;


import java.io.*;

public class Runner {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string to print all its Subsequences : ");
        String word = br.readLine();

        Solution solution = new Solution();
        String[] output = solution.subsequences(word);
        for (String subsequence : output) {
            System.out.println(subsequence);
        }
    }
}
