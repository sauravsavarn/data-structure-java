package org.datastructure.java.adt.stack.stackusingll;


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

public class Stack {

    //Define the data members
    private Node node=null;
    private Node headLL=null;
    private Node tailLL=null;
    private int top=-1;

    public Stack() {
        //Implement the Constructor
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return (top+1);
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return top==-1;
    }

    public void push(int data) {
        //Implement the push(element) function
        if(node==null) {
            node = new Node(data);
            headLL=node;
            tailLL=node;
        } else {
            Node interimNode = new Node(data);
            //node.next=interimNode;
            if(tailLL!=null) {
                tailLL.next = interimNode;
                tailLL = tailLL.next;
            } else{
                tailLL=interimNode;
                headLL=tailLL;
            }
            //tailLL=tailLL.next;
        }
        top++;
    }

    public int pop() {
        //Implement the pop() function
        int data=-1;
        if(top!=-1) {
            data= tailLL.data;
            ////pointing tailLL to the previous node in Linked List
            Node currNode = headLL;
            Node preNode = null;
            int index=0;
            while (index!= top) {
                if(currNode==null || currNode.next ==null)
                    break;

                //
                preNode=currNode;
                currNode=currNode.next;
                index++;
            }
            ////now assigning this new tailLL
            tailLL=currNode;
            data= tailLL.data;
            tailLL=preNode;///////updating tail to previous Node.
        } else
            return -1; /////Practically instead of null this should throw exception and notify user of no further element.

        top--;
        return data;
    }

    public int top() {
        //Implement the top() function
        if(top!=-1)
            return tailLL.data;
        return -1;
    }
}