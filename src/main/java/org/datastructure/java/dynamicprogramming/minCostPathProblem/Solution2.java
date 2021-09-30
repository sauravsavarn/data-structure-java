package org.datastructure.java.dynamicprogramming.minCostPathProblem;

import java.util.Arrays;

////Recursive with Memoization : Dynamic Programming way of Implementation
public class Solution2 {

    public static int minCostPath(int[][] input) {
        //Your code goes here
        int[][] dp = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int minCostPath = minCost(input, 0, 0, input.length, input[0].length, dp);
        return minCostPath;
    }

    private static int minCost(int[][] input, int rowIndex, int colIndex, int maxRowIndex, int maxColIndex, int[][]dp) {
        if ((rowIndex >= maxRowIndex || colIndex >= maxColIndex)) { ////this is the base case
            return Integer.MAX_VALUE;
        } else if(rowIndex==maxRowIndex-1 && colIndex == maxColIndex-1) ////this is the Special Case
            return input[rowIndex][colIndex];
        else if(dp[rowIndex][colIndex]!=-1) return dp[rowIndex][colIndex];

        int ans = input[rowIndex][colIndex] + Math.min(minCost(input, rowIndex, colIndex + 1, maxRowIndex, maxColIndex, dp),
                Math.min(
                        minCost(input, rowIndex + 1, colIndex, maxRowIndex, maxColIndex, dp),
                        minCost(input, rowIndex + 1, colIndex + 1, maxRowIndex, maxColIndex, dp)
                )
        );
        //System.out.println("ans : " + ans);
        dp[rowIndex][colIndex] = ans;
        return ans;
    }

}