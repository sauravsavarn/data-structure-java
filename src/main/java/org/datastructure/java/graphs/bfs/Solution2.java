package org.datastructure.java.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfsTraversal(int[][] adjMatrix, int vertices, int edges) {
        if(edges==0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
            return;
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        queue.add(0);
        traversedVertex[0] = true;
        bfTraversal(adjMatrix, traversedVertex, queue);
    }

    private static void bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue) {

        while (!queue.isEmpty()) {
            int currentVertex = (int) queue.poll();
            System.out.print(currentVertex + " ");

            boolean isConnected = false;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    queue.add(i);
                    traversedVertex[i] = true;
                    isConnected = true;
                }

//                if (!isConnected && i == adjMatrix[currentVertex].length - 1 && currentVertex != adjMatrix.length - 1) {
//                    queue.add(currentVertex + 1);
//                    traversedVertex[currentVertex+1]=true;
//                }

            }
        }

    }
}