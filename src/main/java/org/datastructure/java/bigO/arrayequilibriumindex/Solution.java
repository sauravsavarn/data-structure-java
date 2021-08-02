package org.datastructure.java.bigO.arrayequilibriumindex;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 */
public class Solution {
    static int sumLeftHalf=0;
    static int sumRightHalf=0;
    static int pivotPoint=0;
    static int[] equilibriumIndexesArray;
    static int equilibriumIndex=0;

    public static int arrayEquilibriumIndex(int[] arr){

        equilibriumIndexesArray = new int[arr.length];
        if(arr.length>=0 && arr.length<=2)
            return -1;

        /////// calculate prev. the sum of all the elements in the arr.
        for (int iEle: arr) {
            sumRightHalf += iEle;
        }

        //////now iterate through the array one-by-one
        for (int i = 1; i < arr.length ; i++) {

            if(i==1) {
                sumLeftHalf += arr[0];
                sumRightHalf -= (arr[0]+arr[1]);
            } else {
                sumLeftHalf += arr[i-1];
                sumRightHalf -= (arr[i]);
            }

            pivotPoint = i;
            if(sumLeftHalf == sumRightHalf) {
                equilibriumIndexesArray[equilibriumIndex++] = i;
            }
        }

        OptionalInt item = Arrays.stream(equilibriumIndexesArray).findFirst();
        if(item.isPresent() && item.getAsInt()!=0)  {
            return equilibriumIndexesArray[0];
        } else {
            return -1;
        }
    }
}
