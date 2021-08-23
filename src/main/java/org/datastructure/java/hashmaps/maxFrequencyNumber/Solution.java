package org.datastructure.java.hashmaps.maxFrequencyNumber;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Solution {

    static HashMap<Integer, Integer> hm = new HashMap<>();
    static Vector<Integer> vector = new Vector<>();////to store all those elements having values highest in the entire HashMap. In case of Unique Elements in array, this vector will have only 1 highest element but if there are elemenets found having frequencies same then this will consists of multiple values.
    static int maxValue = Integer.MIN_VALUE;
    static int key=-1;
    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(arr.length==0)return 0;

        /////insert into hashmap and update the frequencies of int occurrence by 1 everytime found.
        for (int arrElement: arr) {
            if(hm.containsKey(arrElement)) hm.put(arrElement, hm.get(arrElement)+1);
            else hm.put(arrElement, 1);
        }

        for (Map.Entry<Integer, Integer> mapElement: hm.entrySet()) {

            if(maxValue < mapElement.getValue()) {
                maxValue=mapElement.getValue();
                key= mapElement.getKey();
            }
        }

        /////now store into vector all those keys having value max found as above
        for (Map.Entry<Integer, Integer> mapElement: hm.entrySet()) {

            if(maxValue == mapElement.getValue()) {
                vector.add(mapElement.getKey());
            }
        }

        ///////finally get the key occurring 1st in the array from amongst the vector element.
        for (int arrElement: arr) {
            if(vector.contains(arrElement)) {
                key = arrElement;
                break;
            }
        }

        return key;
    }
}

