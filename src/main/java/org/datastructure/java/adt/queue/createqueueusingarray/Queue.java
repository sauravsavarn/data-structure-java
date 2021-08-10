package org.datastructure.java.adt.queue.createqueueusingarray;

/*
	For implementing queue using array. Change a bit instead of Array use DynamicArray to take
	care for the doubling the array-size when it's capacity is full.
*/

public class Queue {

    //Define the data members
    private static int[] dynamicQueue;
    private static int front=-1;
    private static int rear=-1;

    public Queue() {
        //Implement the Constructor
        dynamicQueue = new int[10];
    }

    //incrementing the capacity by twice and then copy all elements from Source to Destination.
    private void incQueueCapacity() {
        int[] interimQueue=new int[2*dynamicQueue.length];
        System.arraycopy(dynamicQueue, 0, interimQueue, 0, dynamicQueue.length);
        dynamicQueue=interimQueue;
    }

    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        if(front==-1)
            return 0;
        else
            return (rear-front)+1;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return front==rear && rear==-1;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        if(dynamicQueue.length==rear-front) { ////signifies the queue is full.1st - double the capacity and then enqueue into queue.
            incQueueCapacity();
        }

        dynamicQueue[++rear]=data;

        if(front==-1 & rear!= -1) {
            /////re-align front and rear
            front=rear;
        }
    }


    public int dequeue() {
        //Implement the dequeue() function
        if (rear==-1)
            return -1;
        else {
            int element=dynamicQueue[front];

            ////////now move all the elements by 1 space forward & then re-align both front & head pointer.
            int indexCounter=0;
            while(indexCounter<=rear) {
                dynamicQueue[indexCounter]=dynamicQueue[++indexCounter];
            }
            ////finally re-aligning the front & rear pointer.
            front=0;
            rear-=1;

            return  element;
        }
    }


    public int front() {
        //Implement the front() function
        if(front!=-1)
            return dynamicQueue[front];
        else
            return -1;
    }
}
