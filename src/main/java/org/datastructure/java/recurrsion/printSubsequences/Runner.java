package org.datastructure.java.recurrsion.printSubsequences;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a string to print all its Subsequences : ");
        String word = br.readLine();

        Solution solution = new Solution();
        Solution.printSubsequences(word);
    }
}
