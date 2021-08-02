package org.datastructure.java.bigO.tripletsum;

import java.util.HashSet;

public class Solution4 {
    static int tripletCount = 0;
    static int leftIndex = 0;
    static int rightIndex = 0;

    public static int tripletSum(int[] arr, int num) {

        if(arr.length==0)
            return -1;

        ///////////init left & right index
        leftIndex = 0;
        rightIndex = arr.length - 1;

        ///////////sort array
        //Arrays.sort(arr);

        ///////////Now fix the first element one by one and find the other two elements

        /////initially i==0.... NOTE: we are solving this ProblemStatement with one loop only
        int i=0;
        leftIndex = i + 1; // index of the first element in the remaining elements
        rightIndex = leftIndex + 1;

        while (leftIndex < rightIndex) {
            if (arr[i] + arr[leftIndex] + arr[rightIndex] == num) {
                System.out.println("Triplet is " + arr[i] + ", " + arr[leftIndex] + ", " + arr[rightIndex]);
                tripletCount++;
                rightIndex++;

                if (rightIndex > arr.length && leftIndex < rightIndex) {
                    leftIndex++;
                }
            } else if (arr[i] + arr[leftIndex] + arr[rightIndex] != num) {
                rightIndex++;
            }

            if (rightIndex == arr.length - 1 && leftIndex < rightIndex) {
                if (arr[i] + arr[leftIndex] + arr[rightIndex] == num) {
                    System.out.println("Triplet is1 " + arr[i] + ", " + arr[leftIndex] + ", " + arr[rightIndex]);
                    tripletCount++;
                    rightIndex++;
                } else {
                    leftIndex += 1;
                    rightIndex = leftIndex + 1;
                }

                if (rightIndex >= arr.length && leftIndex < rightIndex) {
                    leftIndex++;
                    rightIndex = leftIndex + 1;
                }

            }

            if (rightIndex > arr.length - 1) {
                if(i < arr.length-3) {
                    i++;
                } else {
                    break;
                }

                leftIndex = i + 1; // index of the first element in the remaining elements
                rightIndex = leftIndex + 1;
            }

        }

        /* ** ** */
        return tripletCount;
    }
}
