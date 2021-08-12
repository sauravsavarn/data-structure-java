package org.datastructure.java.adt.queue.stackusing2queues;


import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    //Define the data members
    private Queue queue1 = new LinkedList(); /////use this queue for all enqueue operation.
    private Queue queue2 = new LinkedList(); /////use this queue for all dequeue operation.

    public Stack() {
        //Implement the Constructor
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return queue1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return queue1.isEmpty();
    }

    public void push(int element) {
        //Implement the push(element) function
        queue1.offer(element);
    }

    public int pop() {
        //Implement the pop() function
        int data=-1;

        //////1st. copy all elements from queue1 to queue2. Now after this operation there is 1 last element left with queue1.
        int queue1Size=queue1.size();
        for (int i = 0; i < queue1Size-1; i++) {
            queue2.offer(queue1.poll());
        }
        //////2nd. remove element from queue2
        if(!queue1.isEmpty())
            data=(int)queue1.poll();
        //////3rd. copy back all the element from queue2 to queue1.
        if(!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }

        return data;
    }

    public int top() {
        //Implement the top() function
        int data=-1;

        //////1st. copy all elements from queue1 to queue2. Now after this operation there is 1 last element left with queue1.
        int queue1Size=queue1.size();
        for (int i = 0; i < queue1Size-1; i++) {
            queue2.offer(queue1.poll());
        }
        //////2nd. remove element from queue2
        if(!queue1.isEmpty()) {
            data = (int) queue1.peek();
            queue2.offer(queue1.poll());
        }
        //////3rd. copy back all the element from queue2 to queue1.
        if(!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }

        return data;

//        if(!queue1.isEmpty())
//            return (int) queue1.peek();
//        else
//            return -1;
    }
}