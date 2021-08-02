package org.datastructure.java.bigO.pairsuminarray;

import java.util.Arrays;
////////there is some issue with this code. this is not the correct implementation
public class Solution2 {
    static int pairCount = 0;

    public static int pairSum(int[] arr, int num) {

        // sort the array in ascending order
        Arrays.sort(arr);

        // maintain two indices pointing to endpoints of the array
        int low = 0;
        int high = arr.length - 1;

        // reduce the search space `A[low…high]` at each iteration of the loop
        // loop till the search space is exhausted
        while (low < high)
        {
            // sum found
            if (arr[low] + arr[high] == num)
            {
                pairCount+=1;
            }

            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if (arr[low] + arr[high] < num) {
                low++;
            }
            else {
                high--;
            }
        }
        return pairCount;

    }
}
