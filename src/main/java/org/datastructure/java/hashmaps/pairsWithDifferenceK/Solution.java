package org.datastructure.java.hashmaps.pairsWithDifferenceK;

import java.util.HashMap;

public class Solution {

    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        if (arr.length == 0) return 0;

        int countPairsWithDifference = 0;
        for (int arrElement : arr) {
            if (hm.isEmpty()) hm.put(arrElement, 1);
            else {
                if (hm.containsKey(arrElement + k)) {
                    System.out.println("arrElement+k = ( "+arrElement+" , "+ (arrElement + k) + " )");
                    countPairsWithDifference += hm.get(arrElement + k);
                    //countPairsWithDifference += 1;
                    //hm.put(arrElement+k, hm.get(arrElement+k)+1);
                } if (hm.containsKey(arrElement - k)) {
                    System.out.println("arrElement-k = ( "+arrElement+" , "+ (arrElement - k) + " )");
                    countPairsWithDifference += hm.get(arrElement - k);
                    //countPairsWithDifference += 1;
                    //hm.put(arrElement-k, hm.get(arrElement-k)+1);
                }
//                if (hm.containsKey(k - arrElement)) {
//                    System.out.println("k-arrElement = ( "+arrElement+" , "+ (k - arrElement) + " )");
//                    countPairsWithDifference += hm.get(k - arrElement);
//                    //hm.put(k-arrElement, hm.get(k-arrElement)+1);
//                }

                if(hm.containsKey(arrElement))
                    hm.put(arrElement, hm.get(arrElement)+1);
                else
                    hm.put(arrElement, 1);

            }
        }

        return countPairsWithDifference;
    }
}