package org.datastructure.java.dynamicprogramming.waysToMakeCoinChange;

/////Recursive approach (without any Dynamic Programming concept)
public class Solution1 {

    public static int countWaysToMakeChange(int denominations[], int value) {
        // Write your code here
        int totalWays = makeCoinChange(denominations, value, 0);
        return totalWays;
    }

    private static int makeCoinChange(int[] denominations, int value, int index) {
        if(index>=denominations.length) return 0;

        if (value == 0)
            return 1;

        if (denominations[index] > value) return 0;


        int ans = makeCoinChange(denominations, value - denominations[index], index)
                + makeCoinChange(denominations, value, index + 1);

        return ans;
    }
}