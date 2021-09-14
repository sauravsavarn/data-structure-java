package org.datastructure.java.backtracking.nQueens;

public class Solution1 {
    public static void placeNQueens(int n) {

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] traversedPath = new int[n][n];
        traverseNPlaceQueens(n, 0, 0, traversedPath);
    }

    static int count=0;
    private static void traverseNPlaceQueens(int n, int rowIndex, int colIndex, int[][] traversedPath) {

        if (rowIndex < 0 || rowIndex >= n || colIndex < 0 || colIndex >= n) return;

        if (rowIndex == n - 1) {
            traversedPath[rowIndex][colIndex]=1;
            ///////print all the path as this is the Valid Board Configuration.
            for (int k = 0; k < traversedPath.length; k++) {
                for (int l = 0; l < traversedPath[0].length; l++) {
                    System.out.print(traversedPath[k][l] + " ");
                    traversedPath[k][l] = 0;
                }
            }
            System.out.println("");
            traversedPath[rowIndex][colIndex] = 0;
            count+=1;
            return;
        }

        ////Check for all the columns regarding placement of the queen
        for (int i = 0; i < n; i++) {
            if (count == n) {
                break;
            }
            /////check if it is safe to place the Queen
            colIndex = i;

            if( (rowIndex>0 && colIndex<n) && (traversedPath[rowIndex-1][colIndex] == 1 || traversedPath[rowIndex-1][colIndex+1] ==1) ) {
                colIndex+=2;
            } else if( (rowIndex>0 && colIndex<n) && traversedPath[rowIndex-1][colIndex+1] ==1 ) {

            } else if( (rowIndex>0 && colIndex<n) && (traversedPath[rowIndex-1][colIndex] == 1 || traversedPath[rowIndex-1][colIndex+1] ==1) ) {

            }

            if( (rowIndex>0 && colIndex<n) && (traversedPath[rowIndex-1][colIndex] == 1 || traversedPath[rowIndex-1][colIndex+1] ==1) ) {
                colIndex+=1;
            }
//            for (int j = 0; j <= rowIndex; j++) {
//                if (traversedPath[j][colIndex] == 1) {
//                    colIndex += 1;
//                }
//            }

            if (traversedPath[rowIndex][colIndex] == 0) {
                traversedPath[rowIndex][colIndex] = 1;
            }
            rowIndex += 1;
            traverseNPlaceQueens(n, rowIndex, colIndex, traversedPath);
            rowIndex = 0;
        }
    }
}