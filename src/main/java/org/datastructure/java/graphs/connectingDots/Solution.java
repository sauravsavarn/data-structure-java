package org.datastructure.java.graphs.connectingDots;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    static Vector<Character> visitedCharacter = new Vector<>(); ///to check already traversed character
    // These arrays are used to get row and column numbers of 8 neighboursof a given cell
    static int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    int solve(String[] board, int N, int M) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        //if(board.length==0 || board.length==1 || board.length<11) return 0;

        /////transpose the matrix
        char[][] adjMatrix = new char[M][N];
        for (int i = 0; i < N; i++) {
            char[] items = board[i].toCharArray();
            for (int j = 0; j < M; j++) {
                adjMatrix[j][i] = items[j];
            }
        }

        int returnValue = checkConnectedDots(adjMatrix, adjMatrix.length, adjMatrix[0].length);
        return returnValue;
    }


    // The main function to find all occurrences of the word in a matrix
    static int checkConnectedDots(char[][] adjMatrix, int ROW, int COL) {
        int returnValue = 0;
        // traverse through the all cells of given matrix
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                // occurrence of first character in matrix
                char chosen = adjMatrix[i][j];
                if (visitedCharacter.isEmpty()) {
                    visitedCharacter.add(chosen);
                } else {
                    if (visitedCharacter.get(0) == chosen) continue;
                    else {
                        visitedCharacter.remove(0);
                        visitedCharacter.add(chosen);
                    }
                }

                Vector<Path> path = new Vector<>();//////
                // check and print if path exists
                returnValue = DFS(adjMatrix, i, j, -1, -1, i, j, path, chosen, ROW, COL);

                if (returnValue == 1) break;
            }

            if (returnValue == 1) break;
        }

        return returnValue;
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbours as adjacent vertices
    static int DFS(char mat[][], int row, int col, int prevRow, int prevCol, int startRow, int startCol, Vector<Path> path, char chosen,
                   int ROW, int COL) {

        boolean visitedVertex= false; ///to check that the row & col is already traversed
        for (int i = 0; i < path.size(); i++) {
            if(path.get(i).chosenCharacter == chosen && path.get(i).row==row && path.get(i).col==col) {
                visitedVertex=true;
            }
        }
        if(visitedVertex)return 0;


        // return if current character doesn't match with the next character in the word
        if (mat[row][col] != chosen)
            return 0;

        // append current character position to path
        Path chosenPath = new Path(chosen, row, col);
        path.add(chosenPath);
        //path += (chosen) + "(" + String.valueOf(row) + ", " + String.valueOf(col) + ") ";

        // current character matches with the last character in the word
        if (row == startRow && col == startCol && path.size() >= 4) {
            if (path.size() == 4 && path.get(0).row == path.get(3).row && path.get(0).col == path.get(3).col)
                return 0;

            for (Path pathItm : path) {
                String pathStr = (pathItm.chosenCharacter) + "(" + String.valueOf(pathItm.row) + ", " + String.valueOf(pathItm.col) + ") ";
                System.out.print(pathStr + "\n");
            }
            //System.out.print(path + "\n");
            return 1;
        }

        int returnValue = 0;
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            if (isvalid(row + rowNum[k], col + colNum[k], prevRow, prevCol, ROW, COL))
                returnValue = DFS(mat, row + rowNum[k], col + colNum[k], row, col, startRow, startCol, path, chosen, ROW, COL);

            if (returnValue == 1) return returnValue;
        }

        return 0;
    }

    // check whether given cell (row, col) is a valid cell or not.
    static boolean isvalid(int row, int col, int prevRow, int prevCol, int ROW, int COL) {
        // return true if row number and column number is in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !(row == prevRow && col == prevCol);
    }
}

class Path {
    char chosenCharacter = '\0';
    int row;
    int col;

    public Path(char chosenCharacter, int row, int col) {
        this.chosenCharacter = chosenCharacter;
        this.row = row;
        this.col = col;
    }
}