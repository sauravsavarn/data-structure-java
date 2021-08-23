package test.nextNumber;

/***************
 * Following is the Node class already written
 class LinkedListNode<T> {
 T data;
 LinkedListNode<T> next;

 public LinkedListNode(T data) {
 this.data = data;
 }
 }
 ***************/

public class Solution {

    public static LinkedListNode<Integer> nextLargeNumber1(LinkedListNode<Integer> head) {
        if(head==null)return null;

        // Add 1 to linked list from end to beginning
        int carry = addWithCarry(head);

        // If there is carry after processing all nodes,
        // then we need to add a new node to linked list
        if (carry > 0)
        {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(carry);
            newNode.next = head;
            return newNode; // New node becomes head now
        }

        return head;
    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        if(head==null)return null;

        //return addBy1(head);
        return addDigit(head,1);
    }

    // Function to add a single-digit number to a singly linked list
    // whose nodes represent digits of a number
    static LinkedListNode<Integer> addDigit(LinkedListNode<Integer> head, int digit)
    {
        // empty list
        if (head == null) {
            return head;
        }

        // reverse the linked list
        head = reverse(head);

        // initialize carry with the given digit
        int carry = digit;

        // traverse the reversed list
        LinkedListNode<Integer> curr = head;
        while (carry > 0)
        {
            // get a sum of the current node and carry
            int sum = curr.data + carry;

            // update value of the current node with the single-digit sum
            curr.data = sum % 10;

            // set carry for the next node
            carry = sum / 10;

            // break if the current node is the last
            if (curr.next == null) {
                break;
            }

            // move to the next node
            curr = curr.next;
        }

        // add a new node at the end of the linked list if there is any carry left
        if (carry > 0) {
            curr.next = new LinkedListNode<Integer>(carry);
        }

        // reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }

    // Function to reverse a given linked list
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next;

        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            next = current.next;

            // fix the current node
            current.next = prev;

            // advance the two pointers
            prev = current;
            current = next;
        }

        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }


    static LinkedListNode<Integer> addBy1(LinkedListNode<Integer> head) {
        // Return head of list after adding one
        LinkedListNode<Integer> ln = head;

        if (head.next == null)
        {
            head.data += 1;
            return head;
        }

        LinkedListNode<Integer> t = head;
        int prev;

        while (t.next != null)
        {
            if (t.data != 9)
            {
                ln = t;
            }
            t = t.next;
        }
        if (t.data == 9 && ln != null)
        {
            t = ln;
            t.data += 1;
            t = t.next;
            while (t != null)
            {
                t.data = 0;
                t = t.next;
            }
        }
        else
        {
            t.data += 1;
        }
        return head;
    }

    // Recursively add 1 from end to beginning and returns
    // carry after all nodes are processed.
    static int addWithCarry(LinkedListNode<Integer> head)
    {

        // If linked list is empty, then
        // return carry
        if (head == null || head.next==null)
            return 1;

        // Add carry returned be next node call
        int res = head.data + addWithCarry(head.next);

        // Update data and return new carry
        head.data = (res) % 10;
        return (res) / 10;
    }


}
