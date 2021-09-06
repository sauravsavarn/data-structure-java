package org.datastructure.java.recurrsion.returnSubsetOfAnArray;

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
    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int input[]) {
        // Write your code here
        if(input.length==0) return null;

        Vector<Integer> v = new Vector<>();
        Vector<_2DArray> vector = findSubsets(input, v);

        /////
        int[][] output = new int[vector.size()-1][];
        for (int i = 1; i < vector.size(); i++) {
            if(vector.get(i)!=null && vector.get(i).getToAsArray() !=null) {
                output[i-1] = vector.get(i).getToAsArray();
            }
        }

        return output;
    }

    public static Vector<_2DArray> findSubsets(int[] input, Vector<Integer> v) {
        if(input.length==0) {
            Vector<_2DArray> v1 = new Vector<>();
            v1.add(null);
            return v1;
        }

        int[] smallerInput = new int[input.length-1];
        System.arraycopy(input, 1, smallerInput, 0, smallerInput.length);
        Vector<_2DArray> smallerOutput = findSubsets(smallerInput, v);
        Vector<_2DArray> output = new Vector<>(smallerOutput.size()*2);

        /////firstly, copy only the elements of smallerOutput into new array 'output'.
        for (int i = 0; i < smallerOutput.size(); i++) {
            output.add(smallerOutput.get(i));
        }
        /////secondly, combination of smallerOutput with input[0].
        for (int i = 0; i < smallerOutput.size(); i++) {
            _2DArray arr = smallerOutput.get(i);
            if(arr==null) {
                _2DArray newArr = new _2DArray(input[0]);
                output.add(newArr);
            }else {
                _2DArray newArr = new _2DArray(input[0]);
                for (int j = 0; j < arr.sizeTo(); j++) {
                    newArr.addTo(arr.v.get(j));
                }
                output.add(newArr);
            }
        }

        /* ** ** */
        return output;
    }
}
