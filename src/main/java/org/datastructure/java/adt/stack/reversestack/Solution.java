package org.datastructure.java.adt.stack.reversestack;


import java.util.Stack;
//////NOTE: this is the optimal Solution. As for reverse of Stack, we need atleast 2 extra's
/////////// but Since here we are only allowed to use 1 extra passed as argument, hence
/////////// we will be using Implicit Stack
public class Solution {

    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        //Your code goes here
        while (!input.isEmpty()) {
            extra.push(input.pop());
        }
        implicitStack(extra, input);
        while (!input.isEmpty()) {
            extra.push(input.pop());
        }
        while (!extra.isEmpty()) {
            input.push(extra.pop());
        }
    }

    public static Stack<Integer> implicitStack(Stack<Integer> extra, Stack<Integer> input) {
        if(extra.size()==0)
            return extra;

        int ele = extra.pop();
        Stack<Integer> s = implicitStack(extra, input);
        input.push(ele);
        return input;
    }
}