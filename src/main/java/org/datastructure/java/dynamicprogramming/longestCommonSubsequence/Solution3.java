package org.datastructure.java.dynamicprogramming.longestCommonSubsequence;


import java.util.HashMap;

/////Recursive approach with Memoization (Dynamic Programming)
public class Solution3 {

    private static HashMap<String, Integer> hm = new HashMap<>();
    public static int lcs(String s, String t) {
        //Your code goes here
        hm.put("", 0);
        int ans = longestCommonSubsequence(s, t);
        return ans;
    }

    private static int longestCommonSubsequence(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return 0;

        int ans1=0;
        if(s.charAt(0)==t.charAt(0)) {
            if(hm.containsKey(s.substring(1)+t.substring(1)))
                ans1 = 1 + hm.get(s.substring(1)+t.substring(1));
            else {
                ans1 = 1 + longestCommonSubsequence(s.substring(1), t.substring(1));
                hm.put(s.substring(1)+t.substring(1), ans1);
            }
        } else {
            if(hm.containsKey(s.substring(1)+t))
                ans1 += hm.get(s.substring(1)+t);
            else {
                ans1 += longestCommonSubsequence(s.substring(1), t);
                hm.put(s.substring(1)+t, ans1);
            }
        }

        int ans2=0;
        if(s.charAt(0)==t.charAt(0)) {
//            if(hm.containsKey(s.substring(1)+t.substring(1)))
//                ans2 = 1 + hm.get(s.substring(1)+t.substring(1));
//            else {
//                ans2 = 1 + longestCommonSubsequence(s.substring(1), t.substring(1));
//                hm.put(s.substring(1)+t.substring(1), ans2);
//            }
        } else {
            if(hm.containsKey(s+t.substring(1)))
                ans2 += hm.get(s+t.substring(1));
            else {
                ans2 += longestCommonSubsequence(s, t.substring(1));
                hm.put(s+t.substring(1), ans2);
            }
        }

        int ans = Math.max(ans1, ans2);
        return ans;
    }
}
