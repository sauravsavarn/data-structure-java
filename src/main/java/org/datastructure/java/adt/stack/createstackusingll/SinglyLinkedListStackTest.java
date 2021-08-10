package org.datastructure.java.adt.stack.createstackusingll;

public class SinglyLinkedListStackTest {

    private SinglyNodeTest node=null;
    private SinglyNodeTest headLL=null;
    private SinglyNodeTest tailLL=null;
    private int top=-1;

    public void push(int data) {

        if(node==null) {
            node = new SinglyNodeTest(data);
            headLL=node;
            tailLL=node;
        } else {
            SinglyNodeTest interimNode = new SinglyNodeTest(data);
            node.next=interimNode;
            tailLL=node;
        }
        top++;
    }

    public int size() {
        return (top+1);
    }

    public int top() {
        return tailLL.data;
    }

    public int pop() {
        int data=-1;
        if(top!=-1) {
            data= tailLL.data;
            ////pointing tailLL to the previous node in Linked List
            SinglyNodeTest currNode = headLL;

            while (currNode.next.next!=null) {
                if(currNode!=null || currNode.next !=null)
                    break;

                //
                currNode=currNode.next;
            }
            ////now assigning this new tailLL
            tailLL=currNode;
        } else
            return -1; /////Practically instead of null this should throw exception and notify user of no further element.

        top--;
        return data;
    }

    public boolean isEmpty() {
        return top==-1;
    }
}

////////Node Template -- to define doubly linked list
class SinglyNodeTest {
    int data;
    SinglyNodeTest next;

    public SinglyNodeTest(int data) {
        this.data=data;
    }
}
