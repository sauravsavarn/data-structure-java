package org.datastructure.java.hashmaps.printIntersection;

import java.util.HashMap;

public class Solution {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void printIntersection(int[] arr1,int[] arr2){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        /////proceed with the insertion of arr1 first into hashmap
        for (int arrElement: arr1) {
            if(hm.containsKey(arrElement)) {
                hm.put(arrElement, hm.get(arrElement)+1);
            } else
                hm.put(arrElement, 1);
        }


        //////now iterate another array i.e. arr2 to check for the existance of element into HashMap.
        for (int arrElement: arr2) {

            if(hm.containsKey(arrElement)) {
                System.out.println(arrElement);
                /////also decrement count from HashMap by 1
                hm.put(arrElement, hm.get(arrElement)-1);

                if(hm.get(arrElement)==0) {
                    /////remove element from HashMap
                    hm.remove(arrElement);
                }
            }
        }

    }
}