package org.datastructure.java.dynamicprogramming.longestCommonSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String s = br.readLine().trim();
        String t = br.readLine().trim();


        //System.out.println(Solution1.lcs(s, t));
        //System.out.println(Solution2.lcs(s, t));
        System.out.println(Solution5.lcs(s, t));
    }
}