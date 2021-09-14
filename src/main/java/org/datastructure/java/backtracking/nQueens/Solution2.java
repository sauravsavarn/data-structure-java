package org.datastructure.java.backtracking.nQueens;

public class Solution2 {
    public static void placeNQueens(int n) {

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] board = new int[n][n];
        solveNQueens(board, 0, n);
    }

    /* A recursive utility function to solve N Queen problem */
    static void solveNQueens(int board[][], int col, int N)
    {
        /* base case: If all queens are placed then return true */
        if (col >= N) {
            ////////print board
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("");
            //return true;
        }

        /* Consider this column and try placing this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
            /* Check if the queen can be placed on board[i][col] */
            if (isSafe(board, i, col, N)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                solveNQueens(board, col + 1, N);
                //if (solveNQueens(board, col + 1, N) == true)
                //    return true;

                /* If placing queen in board[i][col] doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in this column col, then return false */
        //return false;
    }


    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placeed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    static boolean isSafe(int board[][], int row, int col, int N)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}