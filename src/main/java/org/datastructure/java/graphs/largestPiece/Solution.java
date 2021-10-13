package org.datastructure.java.graphs.largestPiece;

public class Solution {

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int dfs(String[] edge, int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        /////transpose the matrix
        String[][] adjMatrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            char[] item = edge[i].toCharArray();
            for (int j = 0; j < n; j++) {
                adjMatrix[j][i] = "" + item[j];
            }
        }

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        int largestPiece = largestPiece(adjMatrix, visited, adjMatrix.length, adjMatrix[0].length);
        return largestPiece;
    }

    // The main function to find all occurrences of the word in a matrix
    static int largestPiece(String[][] adjMatrix, boolean[][] visited, int ROW, int COL) {
        int returnValue = 0;
//        // traverse through the all cells of given matrix
//        for (int i = 0; i < ROW; ++i) {
//            for (int j = 0; j < COL; ++j) {
//                // occurrence of first character in matrix
//                if (adjMatrix[i][j].equals("1"))
//                    // check and print if path exists
//                    returnValue = DFS(adjMatrix, i, j, -1, -1, "", ROW, COL);
//            }
//        }
        returnValue = DFS(adjMatrix, visited, 0, 0, -1, -1, "", ROW, COL);
        return returnValue;
    }


    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbours as adjacent vertices
    static int DFS(String mat[][], boolean[][] visited, int row, int col, int prevRow, int prevCol, String path, int ROW, int COL) {
        // return if current character doesn't match with the next character in the word
        if ((row == ROW - 1 && col == COL - 1) || mat[row][col].equals("0"))
            return 0;

        // append current character position to path
        path += "(" + String.valueOf(row) + ", " + String.valueOf(col) + ") ";

        int returnValue = 0;
        // Recur for all connected neighbours
        for (int k = -1; k < 4; ++k) {
            if (k == -1) {
                /////check for the 0th row & 0th col
                returnValue = DFS(mat, visited, row + dir[k+1][0], dir[k+1][1], row, col, path, ROW, COL);
                visited[row][col] = true;
            } else {
                //boolean isValid = isvalid(row + dir[k][0], col + dir[k][1], prevRow, prevCol, ROW, COL);
                boolean isValid = isvalid(row + dir[k][0], dir[k][1], prevRow, prevCol, ROW, COL);
                if (visited[row + dir[k][0]][dir[k][1]]) continue;

                if (isValid) {
                    System.out.println("(row, col) : " + ((row + dir[k][0]) + " , " + (dir[k][1])));
                    //returnValue = DFS(mat, visited,row + dir[k][0], col + dir[k][1], row, col, path, ROW, COL);
                    returnValue = DFS(mat, visited, row + dir[k][0], dir[k][1], row, col, path, ROW, COL);
                    visited[row + dir[k][0]][dir[k][1]] = true;
                }
            }

            if (returnValue == 1) returnValue += 1;
        }

        return returnValue;
    }

    // check whether given cell (row, col) is a valid cell or not.
    static boolean isvalid(int row, int col, int prevRow, int prevCol, int ROW, int COL) {
        // return true if row number and column number is in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !(row == prevRow && col == prevCol);
    }

}