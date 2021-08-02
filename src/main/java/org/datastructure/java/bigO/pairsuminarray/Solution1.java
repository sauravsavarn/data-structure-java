package org.datastructure.java.bigO.pairsuminarray;

import java.util.Arrays;

public class Solution1 {
    static int pairCount = 0;

    public static int pairSum(int[] arr, int num) {

        if (arr.length == 1)
            return -1;

        ////////sort the array and take only the right half for j, where j=i+1
        Arrays.sort(arr);

        ////////
        for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == num) {
                        pairCount += 1;
                        break;
                    }
                }
        }

        return pairCount;
    }
}
