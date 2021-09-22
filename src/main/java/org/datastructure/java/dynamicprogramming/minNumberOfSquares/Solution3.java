package org.datastructure.java.dynamicprogramming.minNumberOfSquares;

//////this is Iterative DP approach
public class Solution3 {

    public static int minCount(int n) {
        //Your code goes here
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        int ans= Integer.MAX_VALUE;
        for (int i = 1; i <=n ; i++) {
            ans= Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                ans = Math.min(ans, dp[i-j*j] );
                //System.out.println("ans : " + ans);
            }
            dp[i] = ans+1;
        }

        int minSquare = dp[n];
        return  minSquare;
    }
}
