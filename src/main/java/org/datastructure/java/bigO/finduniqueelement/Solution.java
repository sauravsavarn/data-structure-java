package org.datastructure.java.bigO.finduniqueelement;

import java.util.Arrays;

public class Solution {
    public static int findUnique(int[] arr) {
        int output = -1;
        if(arr.length==1)
            return arr[0];
        if(arr.length==2)
            return output;

        //////first sort the arr, this enables like element to come together one-after-another.
        Arrays.sort(arr);

        for (int i = 0; i < arr.length ;) {
            if( (i != arr.length-1) &&  (arr[i] != arr[i+1]) ) {
                output = arr[i];
                break;
            }
            if( i == arr.length-1) {
                output = arr[i];
                break;
            } else {
                i = i+2;
            }
        }

        return output;
    }
}
