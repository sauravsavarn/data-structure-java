package org.datastructure.java.dynamicprogramming.byteLandian;

import java.util.HashMap;

public class Solution2 {

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        for (int i = 0; i <= 11; i++) {
            memo.put((long)i, (long)i);
        }
        long ans = Integer.MIN_VALUE;
        if(n<=11) return memo.get(n);
        else {
            long add = dollarsCount(n, memo);
            ans = Math.max(n, add);
        }

        return ans;
    }

    private static long dollarsCount(long n, HashMap<Long, Long> memo) {

        if(n==0) return 0;
        else if(memo.containsKey(n)) return memo.get(n);

        long temp = 0;
        temp = Math.max(n, dollarsCount(n /2 , memo) + dollarsCount(n /3 , memo) + dollarsCount(n /4 , memo) );

        if(!memo.containsKey(n))
            memo.put(n, temp);

        return temp;
    }
}