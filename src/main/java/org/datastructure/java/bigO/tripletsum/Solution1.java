package org.datastructure.java.bigO.tripletsum;

import java.util.Arrays;

public class Solution1 {
    static int tripletCount = 0;
    static int leftIndex=0;
    static int rightIndex=0;
    public static int tripletSum(int[] arr, int num) {

        ///////////init left & right index
        leftIndex = 0;
        rightIndex = arr.length-1;

        ///////////sort array
        Arrays.sort(arr);

        ///////////Now fix the first element one by one and find the other two elements
        for (int i = 0; i < arr.length - 2; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            leftIndex = i + 1; // index of the first element in the remaining elements
            rightIndex = arr.length - 1; // index of the last element

            while (leftIndex < rightIndex) {
                if (arr[i] + arr[leftIndex] + arr[rightIndex] == num) {
                    System.out.println("Triplet is " + arr[i] + ", " + arr[leftIndex] + ", " + arr[rightIndex]);
                    tripletCount++;
//                    leftIndex++;
                    rightIndex--;
                    //break;
                }
                else if (arr[i] + arr[leftIndex] + arr[rightIndex] < num)
                    leftIndex++;

                else // A[i] + A[l] + A[r] > sum
                    rightIndex--;

            }
        }

        /* ** ** */
        return tripletCount;
    }
}
