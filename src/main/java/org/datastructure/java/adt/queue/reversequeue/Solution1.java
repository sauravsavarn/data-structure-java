package org.datastructure.java.adt.queue.reversequeue;

import java.util.LinkedList;
import java.util.Queue;

//////Recursive way to reverse the Queue. Note: Recursion is the Implicit Stack implementation.
public class Solution1 {

    public static void reverseQueue(Queue<Integer> input) {
        //Your code goes here
        Queue<Integer> queue = recReverseQueue(input);
        //System.out.println("printing reversed queue output : ");
    }

    private static Queue<Integer> recReverseQueue(Queue<Integer> inQ) {
        if(inQ.isEmpty())
            return inQ;

        int element=inQ.poll();
        Queue<Integer> queue= recReverseQueue(inQ);
        queue.offer(element);
        return queue;
    }

}