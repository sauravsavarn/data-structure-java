package org.datastructure.java.hashmaps.maximumFrequencyNumber;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(arr.length==0)return 0;
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            } else
                hm.put(arr[i], 1);
        }

        int keyWithMaxValue=hm.entrySet().stream().min((entry1, entry2) -> entry1.getValue() >= entry2.getValue() ? -1 : 1).get().getKey();
        return keyWithMaxValue;

    }
}

