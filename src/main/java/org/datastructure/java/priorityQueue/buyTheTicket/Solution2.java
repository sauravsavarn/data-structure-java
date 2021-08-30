package org.datastructure.java.priorityQueue.buyTheTicket;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

///////SOlution2 is the Optimal Solution as using PriorityQueue to find the Kth Largest Element instead of manually finding KthLargestElement function as in Solution1
public class Solution2 {

    public static int buyTicket(int input[], int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Queue<Ticket> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(input.length, Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            boolean destinedElement = false;
            if (k == i) {
                destinedElement = true;
            }
            int index = i;
            int priority = input[i];

            //////////adding these information into the Queue
            queue.add(new Ticket(priority, index, destinedElement));
            //////////also add the priority into the PriorityQueue.
            priorityQueue.add(priority);
        }

        int counter = 0;
        int largestElementToGet = 1;
        while (true) {
            Ticket ticket = queue.poll();
            ///////get the 1s Largest Element
            int firstLargestElement = priorityQueue.peek();

            if (ticket.priority == firstLargestElement) {
                counter++;
                largestElementToGet += 1;
                priorityQueue.poll();
            } else {
                queue.add(ticket);
            }

            if (ticket.destinedElement && ticket.priority == firstLargestElement) {
                break;
            }
        }

        return counter;
    }
}

//class Ticket {
//    int priority;
//    int index;
//    boolean destinedElement = false;
//
//    public Ticket(int priority, int index, boolean destinedElement) {
//        this.priority = priority;
//        this.index = index;
//        this.destinedElement = destinedElement;
//    }
//}