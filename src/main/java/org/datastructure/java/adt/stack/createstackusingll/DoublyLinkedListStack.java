package org.datastructure.java.adt.stack.createstackusingll;

public class DoublyLinkedListStack<T> {

    private Node<T> node=null;
    private Node<T> headLL=null;
    private Node<T> tailLL=null;
    private int top=-1;

    public void push(T data) {

        if(node==null) {
            node = new Node<>(data);
            headLL=node;
            tailLL=node;
        } else {
            Node<T> interimNode = new Node<>(data);
            node.next=interimNode;
            interimNode.prev=node;
            tailLL=node.next;
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
            tailLL=tailLL.prev;
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
class Node<T> {
    T data;
    Node next;
    Node prev;

    public Node(T data) {
        this.data=data;
    }
}
