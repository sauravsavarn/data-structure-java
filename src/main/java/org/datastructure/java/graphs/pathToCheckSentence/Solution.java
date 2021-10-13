package org.datastructure.java.graphs.pathToCheckSentence;

public class Solution {

    // For searching in all 8 direction
    // These arrays are used to get row and column numbers of 8 neighboursof a given cell
    static int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    int solve(String[] Graph, int N, int M) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if(Graph.length==0 || Graph.length==1 || Graph.length<11) return 0;

        /////transpose the matrix
        char[][] adjMatrix = new char[M][N];
        for (int i = 0; i < N; i++) {
            char[] items = Graph[i].toCharArray();
            for (int j = 0; j < M; j++) {
                adjMatrix[j][i] = items[j];
            }
        }

        String sentence = "CODINGNINJA";
        int returnValue = findWords(adjMatrix, sentence.toCharArray(), sentence.length()-1, adjMatrix.length, adjMatrix[0].length);
        return returnValue;
    }

    // The main function to find all occurrences of the word in a matrix
    static int findWords(char[][] adjMatrix, char[] word, int n, int ROW, int COL) {
        int returnValue = 0;
        // traverse through the all cells of given matrix
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                // occurrence of first character in matrix
                if (adjMatrix[i][j] == word[0])
                    // check and print if path exists
                    returnValue = DFS(adjMatrix, i, j, -1, -1, word, "", 0, n, ROW, COL);

                if (returnValue == 1) break;
            }

            if(returnValue==1) break;
        }

        return returnValue;
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbours as adjacent vertices
    static int DFS(char mat[][], int row, int col, int prevRow, int prevCol, char[] word, String path, int index, int n, int ROW, int COL) {
        // return if current character doesn't match with the next character in the word
        if (index > n || mat[row][col] != word[index])
            return 0;

        // append current character position to path
        path += (word[index]) + "(" + String.valueOf(row) + ", " + String.valueOf(col) + ") ";

        // current character matches with the last character in the word
        if (index == n) {
            System.out.print(path + "\n");
            return 1;
        }

        int returnValue=0;
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            if (isvalid(row + rowNum[k], col + colNum[k], prevRow, prevCol, ROW, COL))
                returnValue = DFS(mat, row + rowNum[k], col + colNum[k], row, col, word, path, index + 1, n, ROW, COL);

            if(returnValue==1) return returnValue;
        }

        return 0;
    }

    // check whether given cell (row, col) is a valid cell or not.
    static boolean isvalid(int row, int col, int prevRow, int prevCol, int ROW, int COL) {
        // return true if row number and column number is in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !(row == prevRow && col == prevCol);
    }
}