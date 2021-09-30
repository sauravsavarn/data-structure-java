package org.datastructure.java.dynamicprogramming.editDistance;

/////Recursive approach with Memoization (Dynamic Programming)
public class Solution2 {

    public static int editDistance(String s, String t) {
        //Your code goes here
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        int editDistance = editDist(s, t, s.length(), t.length(), dp);
        return editDistance;
    }

    private static int editDist(String str1, String str2, int m, int n, int[][] dp) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1, dp);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        int ans = 0;
        if (dp[m][n] != -1)
            ans = dp[m][n];
        else {
            ans = 1 + Math.min(editDist(str1, str2, m, n - 1, dp), // Insert
                    Math.min(editDist(str1, str2, m - 1, n, dp), // Remove
                            editDist(str1, str2, m - 1, n - 1, dp) // Replace
                    ));
            dp[m][n] = ans;
        }

        return ans;
    }
}
