package org.datastructure.java.dynamicprogramming.longestCommonSubsequence;

/////Recursive approach (without any Dynamic Programming concept)
public class Solution1 {

    public static int lcs(String s, String t) {
        //Your code goes here
        int ans = longestCommonSubsequence(s, t);
        return ans;
    }

    private static int longestCommonSubsequence(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return 0;

        int ans1=0;
        if(s.charAt(0)==t.charAt(0)) {
            ans1 = 1+ longestCommonSubsequence(s.substring(1), t.substring(1));
        } else {
            ans1 += longestCommonSubsequence(s.substring(1), t);
        }

        int ans2=0;
        if(s.charAt(0)==t.charAt(0)) {
            ans2 = 1 + longestCommonSubsequence(s.substring(1), t.substring(1));
        } else {
            ans2 += longestCommonSubsequence(s, t.substring(1));
        }

        int ans = Math.max(ans1, ans2);
        return ans;
    }
}
