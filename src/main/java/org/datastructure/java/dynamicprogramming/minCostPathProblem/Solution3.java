package org.datastructure.java.dynamicprogramming.minCostPathProblem;

////Iteratively with Memoization : Dynamic Programming way of Implementation
public class Solution3 {

    public static int minCostPath(int[][] input) {
        //Your code goes here
        int[][] dp = new int[input.length+1][input[0].length+1];
        for (int i = 0; i <= input.length; i++) {
            for (int j = 0; j <= input[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[input.length-1][input[0].length-1]=input[input.length-1][input[0].length-1];

        for (int i = input.length-1; i >=0 ; i--) {
            for (int j = input[0].length-1; j >=0; j--) {
                int interimMin = Math.min( dp[i][j+1], Math.min( dp[i+1][j], dp[i+1][j+1] ) );
                int k = input[i][j] + ( interimMin == Integer.MAX_VALUE ? 0 : interimMin );
                //System.out.println("i : " + i + " - j : " + j + " - k : " + k);
                dp[i][j] = k;
                //dp[i][j] = input[i][j] +  Math.min( dp[i][j+1], Math.min( dp[i+1][j], dp[i+1][j+1] ) );
            }
        }

        int minCostPath = dp[0][0];
        return minCostPath;
    }
}