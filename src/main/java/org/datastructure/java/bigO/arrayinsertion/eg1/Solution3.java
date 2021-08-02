package org.datastructure.java.bigO.arrayinsertion.eg1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This Solution3 is the most optimal solution with BigO(n)
 */
public class Solution3 {

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < arr1.length; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr1[i]))
                hm.put(arr1[i], 0);

            hm.put(arr1[i], hm.get(arr1[i]) + 1);
        }
        ////////
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr2[i]))
                hm.put(arr2[i], 0);

            //hm.put(arr2[i], hm.get(arr2[i]) + 1);
            Integer ele = hm.get(arr2[i]);
            if(ele!= 0) {
                System.out.print(arr2[i] + " ");
                ////////also decrement key 'arr2' by 1.
                hm.put(arr2[i], hm.get(arr2[i]) - 1);
            }
        }

    }
}
