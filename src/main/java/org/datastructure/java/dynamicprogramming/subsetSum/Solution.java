package org.datastructure.java.dynamicprogramming.subsetSum;

public class Solution {

    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        // Write your code here
        if (arr.length <= 1) return false;

        return subsets(arr, n, sum);
        //boolean isSubsetPresent = subsets(arr, n, sum);
        //return isSubsetPresent;
    }

    // Returns true if there is a subset of
    // set[] with sum equal to given sum
    private static boolean isSubsetSum(int set[],
                                       int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return subset[sum][n];
    }

    private static boolean subsets(int arr[], int n, int sum) {
        // If remaining sum is 0, then print all elements of current subset.
        if (sum == 0) {
            return true;
        }

        // If no remaining elements,
        if (n == 0)
            return false;

        // We consider two cases for every element.
        // a) We do not include last element.
        // b) We include last element in current subset.
        boolean ans1 = subsets(arr, n - 1, sum);
        boolean ans2 = subsets(arr, n - 1, sum - arr[n - 1]);

        if (ans1 == ans2) return false;
        else return true;
    }
}
