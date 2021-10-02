package org.datastructure.java.dynamicprogramming.smallestSuperSequence;

public class Solution2 {

    public static int smallestSuperSequence(String str1, String str2) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int smallestSuperSeq = superSeq(str1, str2, str1.length(),str2.length());
        return smallestSuperSeq;
    }

    // Returns length of the shortest
    // supersequence of X and Y
    static int superSeq(String X, String Y, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Below steps follow above recurrence
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1
                            + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}
