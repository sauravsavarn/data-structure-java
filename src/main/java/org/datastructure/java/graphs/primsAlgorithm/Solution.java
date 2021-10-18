package org.datastructure.java.graphs.primsAlgorithm;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */

        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                graph[i][j] = 0;
        }
        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x][y] = z;
            graph[y][x] = z;
        }

        //////
        PrismMST prism = new PrismMST();
        /////calling min-spanning-tree
        prism.Prim(graph, V);
    }
}

class PrismMST {

    public void Prim(int G[][], int V) {

        int INF = Integer.MAX_VALUE;

        int no_edge; // number of edge

        // create a array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];

        // set selected false initially
        Arrays.fill(selected, false);

        // set number of edge to 0
        no_edge = 0;

        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph

        // choose 0th vertex and make it true
        selected[0] = true;

        // print for edge and weight
        //System.out.println("Edge : Weight");

        while (no_edge < V - 1) {
            // For every vertex in the set S, find the all adjacent vertices
            // , calculate the distance from the vertex selected at step 1.
            // if the vertex is already in the set S, discard it otherwise
            // choose another vertex nearest to selected vertex at step 1.

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            //System.out.println(x + " - " + y + " :  " + G[x][y]);
            if (x < y)
                System.out.println(x + " " + y + " " + G[x][y]);
            else
                System.out.println(y + " " + x + " " + G[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }
}