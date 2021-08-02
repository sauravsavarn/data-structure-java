package org.datastructure.java.bigO.tripletsum;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution7 {

    static int tripletCount = 0;
    static int leftIndex=0;
    static int rightIndex=0;
    public static int tripletSum(int[] arr, int num) {
        if(arr.length>=0 && arr.length <=2)
            return 0;

        //////sorting original array
        Arrays.sort(arr);

        int[][] temp1 = pairsSum(arr, num);
//        for (int j: temp1) {
//            if(j==0)continue;
//            System.out.println("temp1 : "+j);
//        }

        System.out.println("===== FINALLY PRINTING PERMUTATION ===========");
        //////now closing intersection temp1 with the arr to find the triplet sum == num passed as parameter.
        for (int j = 0; j < arr.length-2; j++) {
            for (int i = j; i < temp1.length; i++) {
                if(j >= temp1[i][0] )
                    continue;

                if( (arr[j] + temp1[i][1]) == num ) {
                    System.out.println(arr[j] + " " + temp1[i][0]);
                    tripletCount++;
                }
            }
        }

        System.out.println("===== FINALLY PRINTING RESULT ===========");
        return tripletCount;
    }

    /**
     * find all possible pairs
     * @param arr
     * @return
     */
    private static int[][] pairsSum(int[] arr, int num) {
        int[][] temp = new int[fact(arr.length-2)][2];

        int k=0;
        for (int i = 1; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(num >= (arr[i] + arr[j]) ) {
                    System.out.println("index " + i + " : " + arr[i] + " , " + arr[j]);
                    //temp[arr[i]][0] = arr[i] + arr[j];
                    temp[k][0] = i;
                    temp[k++][1] = arr[i] + arr[j];
                }
            }
        }
        return temp;
    }

    private static int fact(int num) {
        if(num==1)
            return 1;

        int output = num + fact(num-1);
        return output;
    }
}
