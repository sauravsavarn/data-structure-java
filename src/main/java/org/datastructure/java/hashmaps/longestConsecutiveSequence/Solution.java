package org.datastructure.java.hashmaps.longestConsecutiveSequence;

import java.util.*;

public class Solution {
    static HashMap<Integer, Boolean> hm = new HashMap<>();
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        /////add all the elements from arr[] into HashMap
        for (int arrElement: arr) hm.put(arrElement, true);

        Vector<Integer> vector = new Vector<>();
        //////now finding the required sets of details
        int j=0;
        int maxSequence=0; int tempMaxSequence=0;
        int endElement=-1; int tempEndElement=-1;
        int startElement=-1; int tempStartElement=-1;
        for (int i = j; i < arr.length;) {
            if( hm.containsKey( arr[i] - j ) ) {
                if( hm.get(arr[i]-j ) ==false ) {
                    hm.put(arr[i]-j, true);
                }
                //maxSequence+=1;
                tempMaxSequence+=1;
                if(tempStartElement==-1) {
                    tempStartElement=arr[i];
                }
                tempEndElement=arr[i]-j;
                hm.put(arr[i]-j, false);
                j++;
            } else {
                if(maxSequence<=tempMaxSequence) {
                    maxSequence=tempMaxSequence;
                    startElement=tempStartElement;
                    endElement=tempEndElement;
                }
                i++;
                j=0;
                tempMaxSequence=0;tempStartElement=-1;tempEndElement=-1;
            }

        }

        return new ArrayList<>(Arrays.asList(endElement, startElement));
    }
}