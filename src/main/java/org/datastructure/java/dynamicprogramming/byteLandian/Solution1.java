package org.datastructure.java.dynamicprogramming.byteLandian;

import java.util.HashMap;
public class Solution1 {

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        //memo.put((long)0, 0L);memo.put((long)1, 1L);
        for (int i = 0; i <= 11; i++) {
            memo.put((long)i, (long)i);
        }
        for (int i = 0; i <= n; i++) {
            long dollar = Math.max(memo.get((long)i)==null? Integer.MIN_VALUE: memo.get( (long)i ), memo.get(((long)i)/2)+memo.get(((long)i)/3)+memo.get(((long)i)/4));
            memo.put((long) i, dollar);
            //System.out.println("dollar : " + dollar);
        }

        //System.out.println("dollar : " + memo.get(n));
        return memo.get(n);
    }
}
