package org.datastructure.java.backtracking.ratInAMaze;

public class Solution1 {
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
        if (rowIndex >= maze.length || colIndex >= maze[0].length || rowIndex < 0 || colIndex < 0) {
            return false;
        }
        if (rowIndex == maze.length - 1 && colIndex == maze[0].length - 1) {
            traversedPath[rowIndex][colIndex] = 1;
            return traversedPath[rowIndex][colIndex] == 1;
        }
        if (maze[rowIndex][colIndex] == 0) {
            colIndex -= 1;
            return false;
        }

        /////
        if (colIndex == maze[0].length - 1) {
            if (maze[rowIndex + 1][colIndex] == 0) {
                colIndex -= 1;
                return false;
            } else {
                rowIndex+=1; return true;
            }
        }
        if (colIndex == maze[0].length - 1) rowIndex += 1;

        traversedPath[rowIndex][colIndex] = 1;
        boolean output = checkMaze(maze, rowIndex, colIndex + 1, traversedPath);

        if (!output)
            output = checkMaze(maze, rowIndex + 1, colIndex, traversedPath);

        return output;
        //if(traversedPath[maze.length-1][maze[0].length-1]==1) return true;
        //else return false;
    }

    private static boolean checkMaze1(int maze[][], int traversedPath[][]) {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {

                if (maze[i][j] != 0) {
                    traversedPath[i][j] = 1; /////mark the grid as traversed.
                } else break;

            }
        }

        if (traversedPath[maze.length - 1][maze[0].length - 1] == 1) return true;
        else return false;
    }

}