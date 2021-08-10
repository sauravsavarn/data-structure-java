package org.datastructure.java.adt.queue.createqueueusingll;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUse {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Queue queue = new Queue();

        int q = s.nextInt();

        while (q > 0) {
            int choice, input;
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    input = s.nextInt();
                    queue.enqueue(input);
                    break;

                case 2:
                    System.out.println(queue.dequeue());
                    break;

                case 3:
                    System.out.println(queue.front());
                    break;

                case 4:
                    System.out.println(queue.getSize());
                    break;

                default:
                    System.out.println((queue.isEmpty()) ? "true" : "false");
            }

            q -= 1;
        }

    }

}