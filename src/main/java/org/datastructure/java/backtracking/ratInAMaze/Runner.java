package org.datastructure.java.backtracking.ratInAMaze;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maze[i][j] = s.nextInt();
            }
        }
        //System.out.println(Solution1.ratInAMaze(maze));
        System.out.println(Solution2.ratInAMaze(maze));
    }
}
