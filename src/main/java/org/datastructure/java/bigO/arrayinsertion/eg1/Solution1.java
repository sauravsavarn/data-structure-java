package org.datastructure.java.bigO.arrayinsertion.eg1;

import java.util.Arrays;

public class Solution1 {
    public static void intersection(int[] arr1, int[] arr2) {
        System.out.println("testing");
        System.out.println("\n");
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int k=0;
        for(int i: arr1) {
            for (int j = k; j < arr2.length; j++) {
                if(i==arr2[j]) {
                    System.out.print(arr2[j] + " ");
                    k++;
                    break;
                }
            }
        }
    }
}
