package test.createDequeue;

import java.util.LinkedList;

/******************
 * Following is the main function we are using internally.
 * Refer this for completing the Dequeue class
 *

 public static void main(String[] args) {
 Scanner s = new Scanner(System.in);

 Dequeue dq = new Dequeue(10);

 while(true){
 int choice = s.nextInt(),input;
 switch (choice) {
 case 1:
 input = s.nextInt();
 dq.insertFront(input);
 break;
 case 2:
 input = s.nextInt();
 dq.insertRear(input);
 break;
 case 3:
 dq.deleteFront();
 break;
 case 4:
 dq.deleteRear();
 break;
 case 5:
 System.out.println(dq.getFront());
 break;
 case 6:
 System.out.println(dq.getRear());
 break;
 default:
 return ;
 }
 }
 }
 ******************/

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node(T data) {
        this.data = data;
    }
}

public class Dequeue {
    // Complete this class

    private static Node<Integer> front;
    private static Node<Integer> rear = null;
    private static int size = 0;
    private static int capacity = 0;

    public Dequeue(int data) {
        capacity = data;
        front = null;
        rear = null;
        size = 0;
    }

    // Function to check whether deque
    // is empty or not
    boolean isEmpty() {
        return (front == null);
    }

    // Function to return the number of
    // elements in the deque
    int size() {
        return size;
    }

    public void insertFront(int input) {
        Node<Integer> newNode = new Node<Integer>(input);
        // If true then new element cannot be added
        // and it is an 'Overflow' condition
        if (newNode == null) {
            System.out.print(-1);
            return;
        } else {
            if (capacity == 0 || capacity - size <= 0) {
                System.out.println(-1);
                return;
            } else {
                // If deque is empty
                if (front == null)
                    rear = front = newNode;

                    // Inserts node at the front end
                else {
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }

                // Increments count of elements by 1
                size++;
            }
        }
    }

    public void insertRear(int input) {
        Node<Integer> newNode = new Node<Integer>(input);
        // If true then new element cannot be added
        // and it is an 'Overflow' condition
        if (newNode == null) {
            System.out.print(-1);
            return;
        } else {
            if (capacity == 0 || capacity - size <= 0) {
                System.out.println(-1);
                return;
            } else {
                // If deque is empty
                if (rear == null)
                    front = rear = newNode;

                    // Inserts node at the rear end
                else {
                    newNode.prev = rear;
                    rear.next = newNode;
                    rear = newNode;
                }

                size++;
            }
        }
    }

    public int deleteFront() {
        // If deque is empty then
        // 'Underflow' condition
        if (isEmpty()) {
            System.out.println(-1);
            return -1;
        } else { // Deletes the node from the front end and makes the adjustment in the links
            Node<Integer> temp = front;
            front = front.next;

            // If only one element was present
            if (front == null)
                rear = null;
            else
                front.prev = null;

            // Decrements count of elements by 1
            size--;

            return temp.data;
        }
    }

    public int deleteRear() {
        // If deque is empty then
        // 'Underflow' condition
        if (isEmpty()) {
            System.out.println(-1);
            return -1;
        } else { // Deletes the node from the rear end and makes the adjustment in the links
            Node<Integer> temp = rear;
            rear = rear.prev;

            // If only one element was present
            if (rear == null)
                front = null;
            else
                rear.next = null;

            // Decrements count of elements by 1
            size--;
            return temp.data;
        }
    }

    public int getFront() {
        // If deque is empty, then returns
        // garbage value
        if (isEmpty())
            return -1;
        return front.data;
    }


    public int getRear() {
        // If deque is empty, then returns
        // garbage value
        if (isEmpty())
            return -1;
        return rear.data;
    }

}
