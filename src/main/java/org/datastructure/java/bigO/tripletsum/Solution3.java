package org.datastructure.java.bigO.tripletsum;

import java.util.HashSet;

public class Solution3 {
    static int tripletCount=0;
    public static int tripletSum(int[] arr, int num) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr.length - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = num - arr[i];
            for (int j = i + 1; j < arr.length; j++)
            {
                if (s.contains(curr_sum - arr[j]))
                {
                    tripletCount+=1;
                }
                s.add(arr[j]);
            }
        }

        // If we reach here, then no triplet was found
        return tripletCount;
    }
}
