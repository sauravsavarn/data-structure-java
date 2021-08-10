package org.datastructure.java.adt.queue.reverseFirstKElement;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int index=0;
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        //Your code goes here
        if (k==0 || input==null)
            return input;

        reverseFirstKElement(input, k);

        int toBePoppedSize=input.size()-k;
        for (int i = 0; i < toBePoppedSize; i++) {
            input.offer(input.poll());
        }

        return  input;
    }

    private static Queue<Integer> reverseFirstKElement(Queue<Integer> input, int k) {
        if(index==k)
            return input;

        int poppedElement=input.poll();
        index++;
        reverseFirstKElement(input, k);
        input.offer(poppedElement);
        return input;
    }

}