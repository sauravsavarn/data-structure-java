package org.datastructure.java.dynamicprogramming.maximumSquareMatrixWithAllZeros;

public class Solution {

    public static int findMaxSquareWithAllZeros(int[][] input){

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int maxCount=0;
        if(input.length==0) return 0;
        int[][] dp = new int[input.length][input[0].length];
        for (int i = 0; i <input.length ; i++) {
            for (int j = 0; j <input[0].length ; j++) {
                if(1<= i && j==0)
                    dp[i][j] = (input[i][j]==1? 0 : 1);
                else if(i==0 && j>=0)
                    dp[i][j] = (input[i][j]==1? 0 : 1);
                //else if(1<= i && j>=0) continue;
                else dp[i][j] = -1;

                ////
                maxCount = Math.max(maxCount, dp[i][j]);
            }
        }

        /////ITeraTIVE DP Solution
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {

                int maxSq=0;
                if(input[i][j]==1)
                    maxSq=0;
                else
                    maxSq = 1 + Math.min( dp[i-1][j-1], Math.min( dp[i][j-1], dp[i-1][j] ));

                maxCount = Math.max(maxCount, maxSq);
                dp[i][j] = maxSq;
            }
        }

        return maxCount;
    }
}
