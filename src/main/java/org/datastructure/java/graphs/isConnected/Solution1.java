package org.datastructure.java.graphs.isConnected;

import java.util.LinkedList;
import java.util.Queue;

//////Solution1 will give Time Limit Exceeded error as unable to execute in 1 sec as due a lot of work this code is doing everytime.
public class Solution1 {

    static Queue<Integer> queue = new LinkedList<>();

    public static boolean isConnected(int[][] adjMatrix, int vertices, int edges) {
        if (vertices ==0 && edges == 0) {
            return true;
        }

        int vertexFrom = 0; boolean isConnected = true;
        for (int i = 1; i <vertices ; i++) {
            int vertexTo = i;

            queue.clear();
            boolean[] traversedVertex = new boolean[adjMatrix.length];
            queue.add(vertexFrom);
            traversedVertex[vertexFrom] = true;
            boolean hasPathExists = bfTraversal(adjMatrix, traversedVertex, queue, vertexTo);

            if(!hasPathExists) {
                isConnected = false; break;
            }
        }

        return isConnected;
    }

    private static boolean bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue, int vertexTo) {

        boolean isConnected = false;
        while (!queue.isEmpty()) {
            int currentVertex = (int) queue.poll();
            if (currentVertex == vertexTo) {
                isConnected = true;
                break;
            }

            for (int i = adjMatrix.length - 1; i >= 0; i--) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    queue.add(i);
                    traversedVertex[i] = true;
                }

            }
        }

        return isConnected;
    }

}