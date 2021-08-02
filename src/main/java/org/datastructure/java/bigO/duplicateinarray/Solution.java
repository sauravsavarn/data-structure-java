package org.datastructure.java.bigO.duplicateinarray;

import java.util.Arrays;

public class Solution {
    public static int findDuplicate(int[] arr) {
        int output = -1;
        if(arr.length==1)
            return -1;

        if(arr.length==2) {
            if(arr[0]==arr[1])
                return arr[0];
            else
                return -1;
        }

        //////////if the array has more than 2 element then sort
        Arrays.sort(arr);

        for (int i = 0; i < arr.length ;) {
            if( (i != arr.length-1) &&  (arr[i] == arr[i+1]) ) {
                output = arr[i];
                break;
            }
            if( (i == arr.length-1) && (arr[i-1] == arr[i] ) ) {
                output = arr[i];
                break;
            } else {
                i = i+1;
            }
        }

        return output;
    }
}
