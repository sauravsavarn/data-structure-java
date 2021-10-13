package org.datastructure.java.graphs.threeCycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    // Number of vertices
    public static final int V = 3;
    static int count = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int solve(boolean[][] graph, int n) {
        /*
         * Your class should be named Solution
         * You may write your code here
         */
        // all vertex are marked un-visited initially.
        boolean marked[] = new boolean[V];

        // Searching for cycle by using
        // v-n+1 vertices
        for (int i = 0; i < V - (n - 1); i++) {
            DFS(graph, marked, n - 1, i, i);

            // ith vertex is marked as visited
            // and will not be visited again
            marked[i] = true;
        }

        return count / 2;
    }

    static void DFS(boolean graph[][], boolean marked[], int n, int vert, int start) {
        // mark the vertex vert as visited
        marked[vert] = true;

        // if the path of length (n-1) is found
        if (n == 0) {
            // mark vert as un-visited to make it usable again
            marked[vert] = false;

            // Check if vertex vert end with vertex start
            if (graph[vert][start] == true) {
                count++;
                return;
            } else
                return;
        }

        // For searching every possible path of length (n-1)
        for (int i = 0; i < V; i++)
            if (!marked[i] && graph[vert][i] == true)
                // DFS for searching path by decreasing length by 1
                DFS(graph, marked, n - 1, i, start);

        // marking vert as unvisited to make it usable again
        marked[vert] = false;
    }

    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int m = Integer.parseInt(strNums[1]);

        boolean[][] graphs = new boolean[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true;
            graphs[secondvertex][firstvertex] = true;
        }
        return graphs;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput();

        int ans = solve(graphs, graphs.length);
        System.out.println(ans);

    }
}
