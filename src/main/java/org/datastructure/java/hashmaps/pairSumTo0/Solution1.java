package org.datastructure.java.hashmaps.pairSumTo0;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static int count=0;
    public static int PairSum(int[] input, int size) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(input.length==0)return 0;

        int k=0;
        for (int arrElement: input) {
            if(hm.isEmpty()) {
                hm.put(k++, arrElement);
            } else {
                List list =hm.values().stream().filter(x-> x+arrElement==0).collect(Collectors.toList());
                if(!list.isEmpty()) {
                    list.forEach(x -> count += 1);
                    hm.put(k++, arrElement);
                }
                else {
                    hm.put(k++, arrElement);
                }
            }
        }

        return count;
    }
}