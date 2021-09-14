package org.datastructure.java.backtracking.ratInAMaze;

public class Solution2 {
    public static boolean ratInAMaze(int maze[][]) {

        /*Your class should be named Solution.
         *Don't write main().
         *Don't take input, it is passed as function argument.
         *Don't print output.
         *Taking input and printing output is handled automatically.
         */
        int[][] traversedPath = new int[maze.length][maze[0].length];
        for (int i = 0; i < traversedPath.length; i++) {
            for (int j = 0; j < traversedPath[i].length; j++) {
                traversedPath[i][j] = 0;
            }
        }
        boolean output = checkMaze(maze, 0, 0, traversedPath);
        return output;
    }

    private static boolean checkMaze(int maze[][], int rowIndex, int colIndex, int traversedPath[][]) {
        /////base case.
        //Check if rowIndex, colIndex (i.e. i, j) is Valid or not.
        if(rowIndex<0 || rowIndex >= maze.length || colIndex < 0 || colIndex >= maze[0].length || maze[rowIndex][colIndex]==0 ||
        traversedPath[rowIndex][colIndex]==1)
            return false;

        traversedPath[rowIndex][colIndex]=1; ////Include the cell in the current path.

        //////Destination Cell.
        if( rowIndex == maze.length - 1 && colIndex == maze[0].length - 1 ) {
            //traversedPath[rowIndex][colIndex] = 1;
            return true;
        }

        //traversedPath[rowIndex][colIndex]=1; ////Include the cell in the current path.

        ////// Explore further in all the directions.
        if( checkMaze(maze, rowIndex-1, colIndex, traversedPath) ) return true; //////traverse/explore TOP
        else if( checkMaze(maze, rowIndex, colIndex+1, traversedPath) ) return true; /////traverse/explore RIGHT
        else if( checkMaze(maze, rowIndex, colIndex-1, traversedPath) ) return true; /////traverse/explore LEFT
        else if( checkMaze(maze, rowIndex+1, colIndex, traversedPath) ) return true; /////traverse/explore BOTTOM

        return false;
    }
}