package org.datastructure.java.adt.stack.minimumbracketReversal;


import java.util.Stack;

public class Solution {
    static Stack<Character> stack = new Stack<>();
    static int counterBracketRev = 0;

    public static int countBracketReversals(String input) {


        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '(' || character == '{') stack.push(character);
            else if (character == ')' || character == '}') {
                ////peek stack and check top of Stack for any braces like '{' or '(', if found then remove else untouched.
                if(stack.size()!=0) {
                    if (stack.peek() == '(' || stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(character);
                    }
                } else {
                    stack.push(character);
                }
            }
        }

        //////now if there is any remaining element in Stack pop-reverse a peeked element and check if match can be found using turn or otherwise
        while (!stack.isEmpty()) {
            char character = stack.pop();

            if (!stack.isEmpty()) {
                if (character == stack.peek()) {
                    counterBracketRev+=1;
                    stack.pop();
                } else {
                    ////////checking required
                    counterBracketRev+=2;
                    stack.pop();
                }
            } else {
                counterBracketRev = -1;
            }

        }
        //System.out.println(stack.size());

        return counterBracketRev;

    }

}