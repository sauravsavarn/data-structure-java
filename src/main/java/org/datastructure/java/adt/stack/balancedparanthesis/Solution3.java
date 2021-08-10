package org.datastructure.java.adt.stack.balancedparanthesis;

///////////////NOTE: THIS is the most optimal solution as for very-very large input LinkedList
//////////////////// based implementation will give StackOverflowException i.e. Runtime Exception(s).
public class Solution3 {
    private static StackUsingArray stack = new StackUsingArray();

    public static boolean isBalanced(String expression) {


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') stack.push(')');
            else {
                if (stack.isEmpty() || c != stack.top())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}