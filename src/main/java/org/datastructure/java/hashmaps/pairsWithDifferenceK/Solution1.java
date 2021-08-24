package org.datastructure.java.hashmaps.pairsWithDifferenceK;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    static HashMap<Integer, Integer> hm = new HashMap<>();
    static HashMap<Integer, Integer> hmFinal = new HashMap<>();

    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        if (arr.length == 0) return 0;

        int countPairsWithDifference = 0;
        for (int arrElement : arr) {
            if (hm.isEmpty()) hm.put(arrElement, 1);
            else {
                if (arrElement < 0) {
                    for (Map.Entry<Integer, Integer> elem: hm.entrySet()) {
                        if(Math.abs(elem.getKey())-Math.abs(arrElement)==Math.abs(k)) {
                            countPairsWithDifference+=elem.getValue();
                        }
                    }
                } else if(arrElement >= 0) {
                    for (Map.Entry<Integer, Integer> elem: hm.entrySet()) {
                        if(Math.abs(elem.getKey()-arrElement)==Math.abs(k)) {
                            countPairsWithDifference+=elem.getValue();
                        }
                    }
                }

                ///
                hm.put(arrElement, (hm.containsKey(arrElement)) ? hm.get(arrElement)+1 : 1);
            }
        }

        return countPairsWithDifference;
    }
}