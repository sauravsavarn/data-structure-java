package org.datastructure.java.graphs.hasPath;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static Queue<Integer> queue = new LinkedList<>();

    public static boolean bfsTraversal(int[][] adjMatrix, int vertices, int edges, int vertexFrom, int vertexTo) {
        if(edges==0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
            return false;
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        queue.add(vertexFrom);
        traversedVertex[vertexFrom] = true;
        return bfTraversal(adjMatrix, traversedVertex, queue, vertexTo);
    }

    private static boolean bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue, int vertexTo) {

        boolean isPathExists = false;
        while (!queue.isEmpty()) {
            int currentVertex = (int) queue.poll();
            if(currentVertex==vertexTo) {isPathExists=true; break;}

            boolean isConnected = false;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    queue.add(i);
                    traversedVertex[i] = true;
                }

            }
        }

        return isPathExists;
    }
}