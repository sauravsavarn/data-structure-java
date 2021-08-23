package test.createDequeue;

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

//class Node<T> {
//    T data;
//    Node<T> next;
//    Node<T> prev;
//
//    Node(T data) {
//        this.data = data;
//    }
//}

public class Dequeue1 {
    // Complete this class

    private static Node<Integer> front=null, rear =null;
    private static int size = 0;
    private static int capacity = 0;

    public Dequeue1(int data) {
        capacity = data;
    }

    // Function to check whether deque
    // is empty or not
    boolean isEmpty() { return (front == null); }

    public void insertFront(int input) {
        if(capacity==0 || capacity-size<=0){
            System.out.println(-1);return;
        }

        if (front == null) {
            front = new Node<>(input);
            rear = front;
            size = 1;
        } else {
            ////check queue capacity first then insert the data otherwise print -1 & return.
            if(capacity==0 || capacity-size<=0){
                System.out.println(-1);return;
            }
            if(capacity-size>0) {
                Node<Integer> newNode = new Node<>(input);
                front.prev = newNode;
                front = front.prev;
                size += 1;
            }
        }
    }

    public void insertRear(int input) {
        if(capacity==0 || capacity-size<=0){
            System.out.println(-1);return;
        }

        if (front == null) {
            front = new Node<>(input);
            rear = front;
            size = 1;
        } else {
            ////check queue capacity first then insert the data otherwise print -1 & return.
            if(capacity==0 || capacity-size<=0){
                System.out.println(-1);return;
            }
            if(capacity-size>0) {
                Node<Integer> newNode = new Node<>(input);
                rear.next = newNode;
                rear = rear.next;
                size += 1;
            }
        }
    }

    public int deleteFront() {
        int output = -1;
        if (size != 0) {
            if (front.next != null) {
                output = front.data;
                front = front.next;
                size -= 1;
            } else {
                output = front.data;
                front = null;
                rear = null;
                size = 0;
            }
        }

        if(output==-1) System.out.println(-1);
        return output;
    }

    public int getFront() {
        int output = -1;
        if (size != 0) {
            output = front.data;
        }

        return output;
    }


    public int getRear() {
        int output = -1;
        if (size != 0) {
            output = rear.data;
        }

        return output;
    }

    public int deleteRear() {
        int output = -1;
        if (size != 0) {
            if (rear.prev != null) {
                output = rear.data;
                rear = rear.prev;
                size -= 1;
            } else {
                output = rear.data;
                front = null;
                rear = null;
                size = 0;
            }
        }

        if(output==-1) System.out.println(-1);
        return output;
    }


}
