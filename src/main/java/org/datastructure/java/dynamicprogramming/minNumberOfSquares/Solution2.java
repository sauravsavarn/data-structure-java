package org.datastructure.java.dynamicprogramming.minNumberOfSquares;

//////this is Recursive DP approach
public class Solution2 {

    public static int minCount(int n) {
        //Your code goes here
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int minSquare = getMinimum(n, dp);
        return  minSquare;
    }

    private static int getMinimum(int n, int[] dp) {
        if(n==0)return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i*i <= n; i++) {
            if(dp[n-i*i] !=-1)
                ans = Math.min(ans, dp[n-i*i] );
            else {
                int min = getMinimum(n - i * i, dp);
                ans = Math.min(ans, min);
                //ans = Math.min(ans, getMinimum(n - i * i));
                dp[n-i*i] = ans;
            }
        }

        return ans + 1;
    }
}
