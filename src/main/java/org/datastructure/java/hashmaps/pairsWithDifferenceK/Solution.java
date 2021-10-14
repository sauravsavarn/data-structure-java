package org.datastructure.java.hashmaps.pairsWithDifferenceK;

import java.util.HashMap;

/////Solution4 is the most optimal solution
public class Solution {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            int value = map.get(i);
            if (value == arr.length) {
                return (value * (value - 1)) / 2;
            }
        }
        /////NOTE: line no. 15 to 20 is for special case where all numbers are same like
        /// 4
        /// 4 4 4 4
        /// 0
        /// when number of items in array is same as all items in array.

        int count = 0;
        for (int i : arr) {
            if (map.containsKey(i)) {
                int value = map.get(i);
                if (value > 0) {
                    int firstValue = i + k;
                    if (map.containsKey(firstValue)) {
                        count += map.get(i) * map.get(firstValue);
                    }

                    int secondValue = i - k;
                    if (map.containsKey(secondValue)) {
                        count += map.get(i) * map.get(secondValue);
                    }

                    map.put(i, 0);
                }
            }
        }

        return count;

    }
}
