package org.datastructure.java.adt.stack.balancedparanthesis;

import java.util.Vector;

public class StackUsingArray {
    //////////create DS to hold data for Stack
    private Vector vector = new Vector();
    private int top=-1;

    public void push(int data) {
        vector.add(data);
        top++;
    }

    public int size() {
        return vector.size();
    }

    public int top() {
        return (int) vector.elementAt(top);
    }

    public int pop() {
        int data = (int) vector.get(top);
        vector.remove(top);
        top--;
        return data;
    }

    public boolean isEmpty() {
        return top==-1;
    }
}
