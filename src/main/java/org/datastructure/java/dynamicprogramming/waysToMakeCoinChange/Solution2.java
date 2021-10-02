package org.datastructure.java.dynamicprogramming.waysToMakeCoinChange;

/////Recursive approach with Memoization (Dynamic Programming)
public class Solution2 {

    public static int countWaysToMakeChange(int denominations[], int value) {
        // Write your code here
        int[][] dp = new int[denominations.length + 1][value + 1];
        for (int i = 0; i <= denominations.length; i++) {
            for (int j = 0; j <= value; j++) {
                dp[i][j] = 0;
            }
        }
        int totalWays = makeCoinChange(denominations, value, 0, dp);
        return totalWays;
    }

    private static int makeCoinChange(int[] denominations, int value, int index, int[][] dp) {
        if (index >= denominations.length) return 0;

        if (value == 0)
            return 1;

        if (denominations[index] > value) return 0;

        int ans1 = 0;
        if (dp[index][value - denominations[index]] != 0) {
            ans1 = dp[index][value - denominations[index]];
        } else {
            ans1 = makeCoinChange(denominations, value - denominations[index], index, dp);
            dp[index][value - denominations[index]] = ans1;
        }

        int ans2 = 0;
        if (dp[index + 1][value] != 0) {
            ans2 = dp[index + 1][value];
        } else {
            ans2 = makeCoinChange(denominations, value, index + 1, dp);
            dp[index + 1][value] = ans2;
        }

        int ans = ans1 + ans2;
        //int ans = makeCoinChange(denominations, value - denominations[index], index, dp) + makeCoinChange(denominations, value, index + 1, dp);

        return ans;
    }
}