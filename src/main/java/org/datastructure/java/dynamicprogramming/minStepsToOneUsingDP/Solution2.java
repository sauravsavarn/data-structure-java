package org.datastructure.java.dynamicprogramming.minStepsToOneUsingDP;

//////Solution2 using DP with Iterative Programming & Memoization.
public class Solution2 {

    public static int countMinStepsToOne(int n) {
        //Your code goes here
        int[] dp = new int[n+1];
        for (int i = 0; i <=n ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        if(n==1) return dp[0];
        //dp[1]=1;
        for (int i = 1; i <= n; i++) {
            if(i%2==0 && i%3==0) {
                final int min = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3]));
                if(i!=n)
                    dp[i] = min + 1;
                else
                    dp[i] = min;
            }
            else if(i%2==0) {
                final int min = Math.min(dp[i - 1], dp[i / 2]);
                if(i!=n)
                    dp[i] = min + 1;
                else
                    dp[i] = min;
            }
            else if(i%3==0) {
                final int min = Math.min(dp[i - 1], dp[i / 3]);
                if(i!=n)
                    dp[i] = min + 1;
                else
                    dp[i] = min;
            }
            else {
                if(i!=n)
                    dp[i] = dp[i - 1] + 1;
                else
                    dp[i] = dp[i-1];
            }

            System.out.println(i + " - " + dp[i]);
        }
        int output = dp[n];
        return output;
    }

}