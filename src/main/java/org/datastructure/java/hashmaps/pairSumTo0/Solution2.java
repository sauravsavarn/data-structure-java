package org.datastructure.java.hashmaps.pairSumTo0;

import java.util.HashMap;

public class Solution2 {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static int count = 0;

    public static int PairSum(int[] input, int size) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (input.length == 0) return 0;

        for (int arrElement : input) {
            if (hm.isEmpty()) {
                hm.put(arrElement, 1);
            } else {
                if (arrElement < 0) {
                    if (hm.containsKey(-1 * arrElement)) {
                        /////now check for the value and increase count by that value
                        count += hm.get(-1*arrElement);
                    }
                } else {
                    if (hm.containsKey(-1 * arrElement)) {
                        /////now check for the value and increase count by that value
                        count += hm.get(-1*arrElement);
                    }
                }

                if (!hm.containsKey(arrElement))
                    hm.put(arrElement, 1);
                else {
                    hm.put(arrElement, hm.get(arrElement)+1);
                }
            }
        }

        return count;
    }
}