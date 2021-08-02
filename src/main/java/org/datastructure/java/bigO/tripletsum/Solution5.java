package org.datastructure.java.bigO.tripletsum;

import java.util.HashSet;

public class Solution5 {
    static int tripletCount=0;
    public static int tripletSum(int[] arr, int num) {
            if(arr.length==0)
                return 0;

            // Fix the first element as A[i], where i==0
            int i=0;

            // Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = num - arr[i];
            for (int j = i + 1; j < arr.length;)
            {
                if (s.contains(curr_sum - arr[j]))
                {
                    tripletCount+=1;
                }
                s.add(arr[j]);

                if(j == arr.length-1) {
                    //////re-initialise i with the incremented value with some mandatory checks.
                    if(i < arr.length-3) {
                        i++;
                        j = i+1;
                        ///// re-initialise the variables
                        s.clear();
                        curr_sum = num - arr[i];
                    } else {
                        break;
                    }
                } else {
                    j++;
                }
            }

        // If we reach here, then no triplet was found
        return tripletCount;
    }
}
