package org.datastructure.java.recurrsion.printSubsetsSumToK;

import java.util.Vector;

public class Solution {
    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here
        if (input.length <= 1) return;

        Vector<Integer> v= new Vector<Integer>();
        subsets(input, input.length, v, k);
    }

    private static void subsets(int arr[], int n, Vector<Integer> v,
                                int sum)
    {
        // If remaining sum is 0, then print all
        // elements of current subset.
        if (sum == 0) {
            for (int i=v.size()-1;i>=0;i--) {
                System.out.print(v.get(i) + " ");
            }
            System.out.println();
            return;
        }

        // If no remaining elements,
        if (n == 0)
            return;

        // We consider two cases for every element.
        // a) We do not include last element.
        // b) We include last element in current subset.
        subsets(arr, n - 1, v, sum);
        Vector<Integer> v1=new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        subsets(arr, n - 1, v1, sum - arr[n - 1]);
    }
}
