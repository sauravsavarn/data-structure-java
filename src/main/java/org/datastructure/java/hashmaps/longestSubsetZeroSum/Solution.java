package org.datastructure.java.hashmaps.longestSubsetZeroSum;

public class Solution {

    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        int max_len = 0;

        // Pick a starting point
        for (int i = 0; i < arr.length; i++) {
            // Initialize curr_sum for every
            // starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < arr.length; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update
                // max_len
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }
}