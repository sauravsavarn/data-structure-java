package org.datastructure.java.adt.stack.createstackusingll;

public class SinglyLinkedListStack<T> {

    private SinglyNode<T> node=null;
    private SinglyNode<T> headLL=null;
    private SinglyNode<T> tailLL=null;
    private int top=-1;

    public void push(T data) {

        if(node==null) {
            node = new SinglyNode<>(data);
            headLL=node;
            tailLL=node;
        } else {
            SinglyNode<T> interimNode = new SinglyNode<>(data);
            node.next=interimNode;
            tailLL=node;
        }
        top++;
    }

    public int size() {
        return (top+1);
    }

    public T top() {
        return tailLL.data;
    }

    public T pop() {
        T data=null;
        if(top!=-1) {
            data= tailLL.data;
            ////pointing tailLL to the previous node in Linked List
            SinglyNode<T> currNode = headLL;

            while (currNode.next.next!=null) {
                if(currNode!=null || currNode.next !=null)
                    return (T) currNode;

                //
                currNode=currNode.next;
            }
            ////now assigning this new tailLL
            tailLL=currNode;
        } else
            return null; /////Practically instead of null this should throw exception and notify user of no further element.

        top--;
        return data;
    }

    public boolean isEmpty() {
        return top==-1;
    }
}

////////Node Template -- to define doubly linked list
class SinglyNode<T> {
    T data;
    SinglyNode next;

    public SinglyNode(T data) {
        this.data=data;
    }
}
