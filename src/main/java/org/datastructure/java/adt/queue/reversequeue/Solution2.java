package org.datastructure.java.adt.queue.reversequeue;

import java.util.Queue;
///////Recursion way and is the most affordable/optimal solution than Solution1, where we also hold
///////references of return Queue, which is the bad in space complexity and will lead to
///////StackOverflowError for very-very large input queue size(s).
public class Solution2 {
    public static void reverseQueue(Queue<Integer> input) {
        //Your code goes here
        recReverseQueue(input);
        //System.out.println("printing reversed queue output : ");
    }

    private static void recReverseQueue(Queue<Integer> inQ) {
        if(inQ.isEmpty())
            return;

        int element=inQ.poll();
        recReverseQueue(inQ);
        inQ.offer(element);
        return;
    }

}
