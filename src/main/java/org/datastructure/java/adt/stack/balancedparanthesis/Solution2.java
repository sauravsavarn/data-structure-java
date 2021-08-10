package org.datastructure.java.adt.stack.balancedparanthesis;


public class Solution2 {
    private static Stack stack = new Stack();

    public static boolean isBalanced(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if      (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else {
                if (stack.isEmpty() || c != stack.top())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }



}