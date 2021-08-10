package org.datastructure.java.adt.stack.minimumbracketReversal;


import java.util.Stack;

public class Solution {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> tempStack = new Stack<>();
    static int counterBracketRev = 0;

    public static int countBracketReversals(String input) {
        //Your code goes here
        countReverse(input);

        ///////analyse both the stack
        while (!stack.isEmpty()) {
            if (tempStack.isEmpty()) {

                if (stack.size() % 2 == 0) {
                    if (stack.pop() == stack.peek()) {
                        stack.pop();
                        counterBracketRev++;
                    } else {
                        counterBracketRev++;
                        stack.pop();
                        counterBracketRev++;
                    }
                } else {
                    counterBracketRev = -1;
                    break;
                }
            } else {
                if (stack.pop() == stack.peek()) {
                    stack.pop();
                    counterBracketRev++;
                } else {
                    counterBracketRev = -1;
                    break;
                }
            }
        }
        while (!tempStack.isEmpty()) {
            if (stack.isEmpty()) {
                if (tempStack.pop() == tempStack.peek()) {
                    tempStack.pop();
                    counterBracketRev++;
                }

                if (tempStack.size() % 2 != 0) {
                    counterBracketRev = -1;
                    break;
                }
            }
        }

        return counterBracketRev;
    }

    static int countReverse(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{') stack.push('{');
            else {
                /////temp converting character here now
                if (c == '}')
                    c = '{';
                if (!stack.isEmpty() && c != stack.peek()) {
                    tempStack.push(stack.pop());
                    //////checkagain
                    boolean checkAgain = true;
                    while (checkAgain) {
                        if (stack.isEmpty() || c != stack.peek()) {
                            tempStack.push(stack.pop());
                        } else
                            checkAgain = false;
                    }

                } else if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else
                    stack.push('}');
                //else
                //stack.pop();
            }
        }


        return counterBracketRev;
    }

}