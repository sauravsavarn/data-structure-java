package org.datastructure.java.hashmaps.pairsWithDifferenceK;

import java.util.HashMap;


public class Solution3 {

    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        int[][] arrPairs = new int[arr.length][2];
        if (arr.length == 0) return 0;

        int countPairsWithDifference = 0;
        int index=0;
        for (int arrElement : arr) {
            if (hm.isEmpty()) hm.put(arrElement, 1);
            else {
                int minKeyToSearchFor = Math.abs(arrElement) - Math.abs(k) ;
                int maxKeyToSearchFor = Math.abs(arrElement) + Math.abs(k) ;

                //if(minKeyToSearchFor>=0 && hm.containsKey(minKeyToSearchFor) ) {
                if(minKeyToSearchFor>=0 ) {
                    System.out.println(index+1 + " Pair : " + "( " + arrElement + " , " + minKeyToSearchFor + " )");

                    arrPairs[index][0]=arrElement;
                    arrPairs[index++][1]=minKeyToSearchFor;

                    if(index>=arrPairs.length) {
                        //////now its time to increase size of current-array
                        arrPairs=incDynamicArray(arrPairs);
                    }
                }
                //if(maxKeyToSearchFor>=0 && hm.containsKey(maxKeyToSearchFor) ) {
                if(maxKeyToSearchFor>=0 ) {
                    System.out.println(index+1 + " Pair : " + "( " + arrElement + " , " + maxKeyToSearchFor + " )");

                    arrPairs[index][0]=arrElement;
                    arrPairs[index++][1]=maxKeyToSearchFor;

                    if(index>=arrPairs.length) {
                        //////now its time to increase size of current-array
                        arrPairs=incDynamicArray(arrPairs);
                    }
                }
                ///
                hm.put(arrElement, (hm.containsKey(arrElement)) ? hm.get(arrElement) + 1 : 1);
            }
        }

        ////////now finally looping arrPairs and checking existance of both index 0th & 1th against HashMap.
        for (int i = 0; i < arrPairs.length; i++) {
            if( hm.containsKey(arrPairs[i][0]) &&  hm.containsKey(arrPairs[i][1]) && !(arrPairs[i][0]==0 && arrPairs[i][1]==0) ) {
                System.out.println("Key1: " + arrPairs[i][0] + " Key2: " + arrPairs[i][1]);
                countPairsWithDifference += 1;
            }
        }

        return countPairsWithDifference;
    }

    private static int[][]  incDynamicArray(int[][] arrPairs) {
        int currArrSize = arrPairs.length;
        /////now initializing array of size double the size of current array.
        int[][] interimArr = new int[arrPairs.length*2][2];
        /////copying all elements from arrPairs to this new array 'interimArr'.
        for (int i = 0; i < arrPairs.length; i++) {
            interimArr[i][0] = arrPairs[i][0];interimArr[i][1] = arrPairs[i][1];
        }

        return interimArr;
    }
}