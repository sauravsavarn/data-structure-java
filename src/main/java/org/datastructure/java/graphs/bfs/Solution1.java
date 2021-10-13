package org.datastructure.java.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfsTraversal(int[][] adjMatrix, int vertices, int edges) {
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        queue.add(0);
        traversedVertex[0] = true;
        bfTraversal(adjMatrix, traversedVertex, queue);
    }

    private static void bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue) {
        if (queue.isEmpty()) {
            for (int i = 0; i < traversedVertex.length; i++) {
                if(!traversedVertex[i]) System.out.print(i + " ");
            }
            return;
        }

        int vertexTraversed = (int) queue.remove(); //traversedVertex[vertexTraversed] = true;
        System.out.print(vertexTraversed + " ");

        for (int j = 0; j < adjMatrix[vertexTraversed].length; j++) {
            if (adjMatrix[vertexTraversed][j] == 1 && traversedVertex[j] != true) {
                queue.offer(j);
                traversedVertex[j] = true;
            }


        }

        //
        bfTraversal(adjMatrix, traversedVertex, queue);
    }
}