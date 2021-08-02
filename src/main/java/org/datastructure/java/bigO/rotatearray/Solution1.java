package org.datastructure.java.bigO.rotatearray;

import java.util.Arrays;

public class Solution1 {

    public static void rotate(int[] arr, int d) {
        if (arr.length < d)
            return;

        int[] temp =Arrays.copyOf(arr, arr.length);
        int k = 0;
        for (int i = d; i < temp.length; i++) {
            arr[k++] = temp[i];
        }
        for (int i = 0; i < d; i++) {
            arr[k++] = temp[i];
        }
    }
}
