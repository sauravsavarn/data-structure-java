package org.datastructure.java.adt.stack.balancedparanthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        //System.out.println(Solution1.isBalanced(expression));
        //System.out.println(Solution2.isBalanced(expression));
        System.out.println(Solution3.isBalanced(expression));
    }
}