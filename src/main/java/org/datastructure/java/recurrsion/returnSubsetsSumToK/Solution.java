package org.datastructure.java.recurrsion.returnSubsetsSumToK;

import java.util.Vector;

class _2DArray {
    Vector<Integer> v = new Vector();

    public _2DArray() {}
    public _2DArray(int element) {
        v.add(element);
    }

    public void printAll() {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println("");
    }

    public void addTo(int element) {
        v.add(element);
    }

    public Vector<Integer> getTo() {
        return this.v;
    }

    public int[] getToAsArray() {
        int[] arr = new int[sizeTo()];
        for (int i = 0; i < sizeTo(); i++) {
            arr[i]=v.get(i);
        }
        return arr;
    }

    public int sizeTo() {
        return this.v.size();
    }

    public int SumTo() {
        int output = 0;
        for (int i = 0; i < v.size(); i++) {
            output += (int) v.get(i);
        }
        return output;
    }
}

public class Solution {

    static Vector<_2DArray> vector = new Vector<>();

    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here
        if (input.length <= 1) return null;

        Vector<Integer> v= new Vector<Integer>();
        subsets(input, input.length, v, k);

//        for (int i = 0; i < vector.size(); i++) {
//            vector.get(i).printAll();
//        }

        int[][] _2dArr = new int[vector.size()][]; int index=0;
        for (int i = 0; i < vector.size(); i++) {
            int[] arr = vector.get(i).getToAsArray();
            _2dArr[index++]=arr;
        }

        return _2dArr;
    }

    private static void subsets(int arr[], int n, Vector<Integer> v,
                                int sum)
    {
        // If remaining sum is 0, then print all
        // elements of current subset.
        if (sum == 0) {
            _2DArray vec = new _2DArray();
            for (int i=v.size()-1;i>=0;i--) {
                vec.addTo(v.get(i));
                //System.out.print(v.get(i) + " ");
            }
            vector.add(vec);
            //System.out.println();
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