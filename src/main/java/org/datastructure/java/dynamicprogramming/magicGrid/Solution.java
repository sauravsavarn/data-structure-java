package org.datastructure.java.dynamicprogramming.magicGrid;

public class Solution {

    public static int getMinimumStrength(int[][] grid) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        // dp[i][j] represents the minimum initial points player
        // should have so that when starts with cell(i, j) successfully
        // reaches the destination cell(m-1, n-1)
        int dp[][] = new int[grid.length][grid[0].length];

        int minHealth = minStrength(grid, grid.length, grid[0].length, dp);
        return minHealth;
    }

    private static int minStrength(int[][] grid, int maxRow, int maxCol, int[][] dp) {

        // Base case
        dp[maxRow-1][maxCol-1] = grid[maxRow-1][maxCol-1] > 0? 1 : Math.abs(grid[maxRow-1][maxCol-1]) + 1;

        // Fill last row and last column as base to fill entire table
        for (int i = maxRow-2; i >= 0; i--)
            dp[i][maxCol-1] = Math.max(dp[i+1][maxCol-1] - grid[i][maxCol-1], 1);
        for (int j = maxCol-2; j >= 0; j--)
            dp[maxRow-1][j] = Math.max(dp[maxRow-1][j+1] - grid[maxRow-1][j], 1);

        // fill the table in bottom-up fashion
        for (int i=maxRow-2; i>=0; i--)
        {
            for (int j=maxCol-2; j>=0; j--)
            {
                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min_points_on_exit - grid[i][j], 1);
            }
        }

        return dp[0][0];
    }

}
