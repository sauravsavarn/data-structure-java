package org.datastructure.java.dynamicprogramming.coinTower;

public class Solution {

    public static String findWinner(int n, int x, int y) {
        //Your code goes here

        // To store results
        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <=n ; i++) {
            dp[i] = false;
        }

        // Initial values
        dp[0] = false;
        dp[1] = true;

        // Computing other values.
        for (int i = 2; i <= n; i++) {

            // If Beerus losses any of i-1 or i-x or i-y game then he will definitely win game i
            if (i - 1 >= 0 && dp[i - 1] == false)
                dp[i] = true;
            else if (i - x >= 0 && dp[i - x] == false)
                dp[i] = true;
            else if (i - y >= 0 && dp[i - y] == false)
                dp[i] = true;

                // Else 'Beerus' loses game.
            else
                dp[i] = false;
        }

        // If dp[n] is true then Beerus wins game otherwise he losses
        return (dp[n]==true? "Beerus" : "Whis");
    }
}