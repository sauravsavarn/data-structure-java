package org.datastructure.java.dynamicprogramming.knapsack;

/////Recursive approach with Memoization (Dynamic Programming)
public class Solution2 {

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        //Your code goes here
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        //dp[0] = 0;
        int maxValue = knapsackMaxWt(weights, values, n, maxWeight, 0, dp);
        return maxValue;
    }

    private static int knapsackMaxWt(int[] weights, int[] values, int n, int maxWeight, int index, int[] dp) {
        if (index >= n) {
            return 0;
        }

        int maxVal = 0;
        if (weights[index] > maxWeight) {
            if (dp[index] != -1)
                maxVal = dp[index];
            else {
                maxVal = knapsackMaxWt(weights, values, n, maxWeight, index + 1, dp);
//                if(maxVal!=0)
//                    dp[index] = maxVal;
            }
        } else {

            int ans1 = 0;
            if (dp[index] != -1)
                ans1 = dp[index];
            else
                ans1 = values[index] + knapsackMaxWt(weights, values, n, maxWeight - weights[index], index + 1, dp); ///including weights

            int ans2 = 0;
            ans2 = knapsackMaxWt(weights, values, n, maxWeight, index + 1, dp); ////exclusing weights

            maxVal = Math.max(ans1, ans2);
            dp[index] = maxVal;
        }

        System.out.println("Index : " + index + " maxWeight : " + maxWeight + " maxValue : " + maxVal + " dp[index] : " + dp.toString());
        return dp[index];
    }

}
