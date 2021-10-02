package org.datastructure.java.dynamicprogramming.knapsack;

/////Recursive approach (without any Dynamic Programming concept)
public class Solution1 {

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        //Your code goes here
        int maxValue = knapsackMaxWt(weights, values, n, maxWeight, 0);
        return maxValue;
    }

    private static int knapsackMaxWt(int[] weights, int[] values, int n, int maxWeight, int index) {
        if (index >= n) {
            return 0;
        }

        int maxVal = 0;
        if (weights[index] > maxWeight)
            maxVal = knapsackMaxWt(weights, values, n, maxWeight, index+1);
        else {
            int ans1 = values[index] + knapsackMaxWt(weights, values, n, maxWeight - weights[index], index+1); ///including weights
            int ans2 = knapsackMaxWt(weights, values, n, maxWeight, index+1); ////exclusing weights

            maxVal = Math.max(ans1, ans2);

            //maxVal = Math.max( weights[index] + knapsackMaxWt(weights, values, n, maxWeight - weights[index], index+1), ///including weights
            //        knapsackMaxWt(weights, values, n, maxWeight, index+1)); ////exclusing weights

        }

        return maxVal;
    }

}
