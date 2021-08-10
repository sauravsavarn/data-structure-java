package org.datastructure.java.adt.queue.createqueueusingll;

/*
	Following is the structure of the node class for a Singly Linked List

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

*/

public class Queue {

    //Define the data members
    private static Node front = null;
    private static Node rear = null;

    public Queue() {
        //Implement the Constructor
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        if(front==null)
            return 0;
        else {
            Node currNode = front;
            int index=0;
            while(currNode!=null) {
                index+=1;
                currNode=currNode.next;
            }
            return index;
        }
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return front==null;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        if (front == null) {
            front = new Node(data);
            rear = front;
        } else {
            rear.next = new Node(data);
            rear = rear.next;
        }
    }


    public int dequeue() {
        //Implement the dequeue() function
        if (front != null) {
            int data = front.data;
            front = front.next;
            return data;
        } else
            return -1;
    }


    public int front() {
        //Implement the front() function
        if(front!=null)
            return front.data;
        else
            return -1;
    }
}
