package org.datastructure.java.dynamicprogramming.minNumberOfSquares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        //System.out.println(Solution1.minCount(n));
        //System.out.println(Solution2.minCount(n));
        System.out.println(Solution3.minCount(n));
    }
}