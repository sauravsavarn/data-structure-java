package org.datastructure.java.dynamicprogramming.minNumberOfSquares;

public class Solution1 {

    public static int minCount(int n) {
        //Your code goes here
        int minSquare = getMinimum(n);
        return  minSquare;
    }

    private static int getMinimum(int n) {
        if(n==0)return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i*i <= n; i++) {
            ans = Math.min(ans, getMinimum(n-i*i) );
        }

        return ans + 1;
    }
}
