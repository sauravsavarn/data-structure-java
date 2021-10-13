package org.datastructure.java.graphs.bfs;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        if(n==0 && e==0) return;

        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        /////
        Solution1.bfsTraversal(adjMatrix, n, e);
        //Solution2.bfsTraversal(adjMatrix, n, e);
    }

}
