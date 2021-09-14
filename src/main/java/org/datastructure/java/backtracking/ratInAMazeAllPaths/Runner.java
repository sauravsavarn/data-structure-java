package org.datastructure.java.backtracking.ratInAMazeAllPaths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runner {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] maze = new int[20][20];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer tk = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++)
            {
                maze[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        Solution.ratInAMaze(maze, n);
    }
}
