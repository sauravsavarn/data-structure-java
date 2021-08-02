package org.datastructure.java.bigO.arrayinsertion.eg1;

import java.util.Arrays;

public class Solution2 {

    public static void intersection(int[] arr1, int[] arr2) {
        /////////proceed only with Sorting for the array with smaller size
        if(arr1.length> arr2.length) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            /////// using BinarySearch on the smaller sorted array to search for the element from un-sorted array.
            for(int i: arr1) {
                int searchedElementIndex = binarySearch(i, arr2, 0, arr2.length-1);
                if(searchedElementIndex!= -1) {
                    System.out.print( arr2[searchedElementIndex] + " " );
                    /////fill -1 instead of this element-position.
                    arr2[searchedElementIndex]=-1;
                    Arrays.sort(arr2);
                }
            }
        }
        else {
            Arrays.sort(arr2);
            Arrays.sort(arr1);
            /////// using BinarySearch on the smaller sorted array to search for the element from un-sorted array.
            for(int i: arr2) {

                int searchedElementIndex = binarySearch(i, arr1, 0, arr1.length-1);
                if(searchedElementIndex!= -1) {
                    System.out.print( arr1[searchedElementIndex] + " " );
                    /////fill -1 instead of this element-position.
                    arr1[searchedElementIndex]=-1;
                    Arrays.sort(arr1);
                }

            }
        }
    }

    public static int binarySearch(int elementFromBiggerArray, int[] smallerArray, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return -1;

        int minIndex = (startIndex+endIndex)/2;

        if (minIndex > smallerArray.length-1)
            return -1;

        if(elementFromBiggerArray == smallerArray[minIndex]) {
            return minIndex;
        }
        else if(elementFromBiggerArray < smallerArray[minIndex]) {
            return binarySearch(elementFromBiggerArray, smallerArray, startIndex, minIndex-1);
        } else {
            return binarySearch(elementFromBiggerArray, smallerArray, minIndex+1, endIndex);
        }

    }
}
