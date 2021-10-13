package org.datastructure.java.graphs.isConnected;

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

        //if(n==0 && e==0) return;

        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        /////
        //System.out.println(Solution1.isConnected(adjMatrix, n, e));
        System.out.println(Solution2.isConnected(adjMatrix, n, e));
    }

}
