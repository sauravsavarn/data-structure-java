package org.datastructure.java.dynamicprogramming.staircase;

import java.math.BigInteger;

public class Solution {

    public static String staircase(int n) {
        //Your code goes here
        if(n==1 || n==0) return "1";
        else if(n==2) return "2";

        BigInteger[] dp = new BigInteger[n+1];
        dp[0]= BigInteger.valueOf(1);
        dp[1]= BigInteger.valueOf(1);
        dp[2]= BigInteger.valueOf(2);

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]).add(dp[i-3]);
        }

        BigInteger answer = dp[n];
        //int answer = fib(n);
        //System.out.println("answer : " + answer);
        return ""+answer;
    }

    public static long staircase1(int n) {
        //Your code goes here
        int answer = fib(n);
        System.out.println("answer : " + answer);
        return answer;
    }

    private static int fib(int n) {
        if(n==0 || n==1) return 1;
        else if(n==2) return n;

        int ans = fib(n-1) + fib(n-2) + fib(n-3);
        return ans;
    }
}
