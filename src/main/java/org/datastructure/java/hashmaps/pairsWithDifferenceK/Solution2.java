package org.datastructure.java.hashmaps.pairsWithDifferenceK;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        if (arr.length == 0) return 0;

        int countPairsWithDifference = 0;
        for (int arrElement : arr) {
            if (hm.isEmpty()) hm.put(arrElement, 1);
            else {
                if (arrElement < 0) {
                    if(hm.containsKey( Math.abs(Math.abs(k)+Math.abs(arrElement)) )) {
                        countPairsWithDifference+=hm.get( Math.abs(Math.abs(k)+Math.abs(arrElement)) );
                    }
                } else if(arrElement >= 0) {
                    if(hm.containsKey( Math.abs(Math.abs(k)-Math.abs(arrElement)) )) {
                        countPairsWithDifference+=hm.get( Math.abs(Math.abs(k)-Math.abs(arrElement)) );
                    }
                }

                ///
                hm.put(arrElement, (hm.containsKey(arrElement)) ? hm.get(arrElement)+1 : 1);
            }
        }

        return countPairsWithDifference;
    }
}