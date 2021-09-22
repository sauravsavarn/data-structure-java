package org.datastructure.java.dynamicprogramming.byteLandian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        long n = Long.parseLong(br.readLine().trim());
        HashMap<Long, Long> memo = new HashMap<Long, Long>();
        //System.out.println(Solution1.bytelandian(n,memo));
        System.out.println(Solution2.bytelandian(n,memo));
    }
}