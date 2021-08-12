package org.datastructure.java.adt.stack.checkredundantbuckets;


import java.util.Stack;

public class Solution {
    private static Stack stack = new Stack();
    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
        boolean redundantBracket=false;

        int totalSize=expression.length();
        for (int i = 0; i < totalSize; i++) {

            char character = expression.charAt(i);

            if(character=='(' || character=='{') stack.push(character);
            else if(character==')' || character=='}') {
                ////peek stack and check top of Stack for any operator '+', '-', '*', '/'
                if((char)stack.peek()=='+' || (char)stack.peek()=='-' || (char)stack.peek()=='*' || (char)stack.peek()=='/') {
                    stack.pop();
                    boolean checkAgain=true;
                    while(checkAgain) {
                        if((char)stack.peek()=='+' || (char)stack.peek()=='-' || (char)stack.peek()=='*' || (char)stack.peek()=='/') {
                            stack.pop();
                        } else {
                            stack.pop();
                            checkAgain=false;
                        }
                    }
                } else {
                    redundantBracket=true;
                    //redundantBracket=false;
                    break;
                }
            } else if(character=='+' || character=='-' || character=='/' || character=='*') {
                if(stack.size()>0)
                    stack.push(character);
            }
        }

        return redundantBracket;
    }
}