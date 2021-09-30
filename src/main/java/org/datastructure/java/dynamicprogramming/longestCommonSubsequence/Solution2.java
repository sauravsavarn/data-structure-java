package org.datastructure.java.dynamicprogramming.longestCommonSubsequence;

/////Recursive approach (without any Dynamic Programming concept)
/////This is the improved solution as compared to Solution1.
public class Solution2 {

    public static int lcs(String s, String t) {
        //Your code goes here
        int ans = longestCommonSubsequence(s, t);
        return ans;
    }

    private static int longestCommonSubsequence(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return 0;

        int finalAns=0;
        if(s.charAt(0)==t.charAt(0)) {
            finalAns = 1+ longestCommonSubsequence(s.substring(1), t.substring(1));
        } else {
            int ans1 = longestCommonSubsequence(s.substring(1), t);
            int ans2 = longestCommonSubsequence(s, t.substring(1));

            finalAns = Math.max(ans1, ans2);
        }
        return finalAns;
    }
}
