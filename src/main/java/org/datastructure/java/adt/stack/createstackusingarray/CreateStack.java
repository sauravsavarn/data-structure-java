package org.datastructure.java.adt.stack.createstackusingarray;

import java.util.Vector;

public class CreateStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
    }



}

////////NOTE: this implementation for Stack, only allows insertion/removal from 1 end of the DS.
class Stack<T> {
    //////////create DS to hold data for Stack
    private Vector<T> vector = new Vector<>();
    private int top=-1;

    public void push(T data) {
        vector.add(data);
        top++;
    }

    public int size() {
        return vector.size();
    }

    public T top() {
        return vector.elementAt(top);
    }

    public T pop() {
        T data = vector.get(top);
        vector.remove(top);
        top--;
        return data;
    }

    public boolean isEmpty() {
        return top==-1;
    }
}
