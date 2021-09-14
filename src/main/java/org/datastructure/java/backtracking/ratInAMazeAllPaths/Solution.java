package org.datastructure.java.backtracking.ratInAMazeAllPaths;

import java.util.Arrays;

/*
	Note:
	To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
	This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y),
	down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/
public class Solution {

    static void ratInAMaze(int maze[][], int n) {
        /*
         * Your class should be named Solution.
         * Write your code here
         */
        //int[][] traversedPath = new int[maze.length][maze[0].length];
        int[][] traversedPath = new int[n][n];
        traverseMazeNPrintAllPaths(maze, 0, 0, n, traversedPath);
    }

    private static void traverseMazeNPrintAllPaths(int[][] maze, int i, int j, int n, int[][] traversedPath) {
        if(i<0 || i >= maze.length || j<0 || j>= maze[0].length || maze[i][j] == 0 || traversedPath[i][j]==1) return;

        traversedPath[i][j]=1;

        if(i== n-1 && j == n-1) {
            ////////////print this path
            for (int k = 0; k < traversedPath.length; k++) {
                for (int l = 0; l < traversedPath[0].length; l++) {
                    System.out.print(traversedPath[k][l] + " ");
                }
            }
            System.out.println("");
            traversedPath[i][j]=0;
            return;
        }

        //////explore path
        traverseMazeNPrintAllPaths(maze, i-1, j, n, traversedPath);
        traverseMazeNPrintAllPaths(maze, i+1, j, n, traversedPath);
        traverseMazeNPrintAllPaths(maze, i, j-1, n, traversedPath);
        traverseMazeNPrintAllPaths(maze, i, j+1, n, traversedPath);

        traversedPath[i][j]=0;
        return;
    }
}
