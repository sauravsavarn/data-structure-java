package org.datastructure.java.dynamicprogramming.minimumNumberOfChocolates;

public class Solution {

    public static int getMin(int arr[], int N){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int minCount = countMinChocolates(arr, N, dp);
        return minCount;
    }

    private static int countMinChocolates(int arr[], int lArray, int[] dp) {

        int minChocolates = 0;
        /////Left -> Right
        for (int i = 1; i <lArray ; i++) {

            if(arr[i] > arr[i-1]) {
                dp[i] = 1 + dp[i-1];
            } else
                dp[i] = 1;
        }

        minChocolates += dp[lArray-1];
        /////Right -> Left
        for (int i = lArray-2; i >=0 ; i--) {

            if(arr[i]>arr[i+1]) {
                if(dp[i] <= dp[i+1]+1)
                    dp[i] = 1 + dp[i+1];
            }

            minChocolates += dp[i];
        }

        return minChocolates;
    }

}
