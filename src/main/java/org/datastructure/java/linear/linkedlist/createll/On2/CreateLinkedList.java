package org.datastructure.java.linear.linkedlist.createll.On2;


import java.util.Scanner;

public class CreateLinkedList {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Data for LinkedList (-1 to stop inserting into LL)  : ");
        Node<Integer> head = null;
        head = takeInput();
    }

    public static Node<Integer> takeInput() {
        int data = scanner.nextInt();
        Node<Integer> head = null;
        // Node<Integer> tail = null;

        while(data != -1) {
            if(head == null) {
                Node<Integer> currentNode = new Node<>(data);
                head = currentNode;
                // tail = head;
            } else {
                Node<Integer> newNode = new Node<>(data);
                Node<Integer> tail = head;

                while(tail != null) {
                    tail = tail.next;
                }

                tail.next = new Node<>(data);
            }

            //
            data = scanner.nextInt();
        }

        /* ** ** */
        return head;
    }

}

/**
 * Create template for the LinkedList single element i.e. 'Node'.
 *
 * @param <T>
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
