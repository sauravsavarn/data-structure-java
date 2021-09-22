package org.datastructure.java.dynamicprogramming.minStepsToOneUsingDP;

//////Solution1 using DP without Iterative Programming.
public class Solution1 {

    public static int countMinStepsToOne(int n) {
        //Your code goes here

        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int output = countMinStepsTo1(n, dp);
        return output;
    }

    private static int countMinStepsTo1(int n, int[] dp) {

        if(n==1) return 0;

        int ans1 = Integer.MAX_VALUE;
        if(dp[n-1]!=-1)
            ans1 = dp[n-1];
        else {
            ans1 = countMinStepsTo1(n - 1, dp);
            dp[n-1] = ans1;
        }

        int ans2 = Integer.MAX_VALUE;
        if(n%3==0) {
            if(dp[n/3]!=-1)
                ans2 = dp[n/3];
            else {
                ans2 = countMinStepsTo1(n / 3, dp);
                dp[n/3] = ans2;
            }
        }

        int ans3 = Integer.MAX_VALUE;
        if(n%2==0) {
            if(dp[n/2]!=-1)
                ans3 = dp[n/2];
            else {
                ans3 = countMinStepsTo1(n / 2, dp);
                dp[n/2] = ans3;
            }
        }

        int min = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        return min;
    }
}