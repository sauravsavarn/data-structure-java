package org.datastructure.java.adt.stack.balancedparanthesis;


public class Solution1 {
    private static Stack stack = new Stack();

    public static boolean isBalanced(String expression) {


        ///using recursion to put the expression one by one into stack.
        boolean finalStatus = storeNcheckIntoStack(expression, 0);
        return finalStatus && stack.isEmpty();
    }

    private static boolean storeNcheckIntoStack(String expression, int index) {
        if(expression==null || expression.isEmpty())
            return true;

        char character = expression.charAt(index);

        /////storing this character into stack iff no respective opening expression is found
        boolean status = checkNstore(character);

        //index+=1;
        return status && storeNcheckIntoStack(expression.substring(++index), 0);
    }

    private static boolean checkNstore(char character) {
        boolean status=false;
        switch (character) {
            case ')':
                if(stack.top()=='(') {
                    stack.pop();
                    status = true;
                }
                else {

                }

                break;

            default:
                //////store into stack otherwise pop it
                stack.push(character);
                status=true;
                break;
        }

        return status;
    }


}