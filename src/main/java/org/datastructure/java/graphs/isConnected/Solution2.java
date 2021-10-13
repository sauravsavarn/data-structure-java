package org.datastructure.java.graphs.isConnected;

import java.util.LinkedList;
import java.util.Queue;

//////Solution2 is the optimal solution. As here we are checking traversedVertex array finally after BFS traversal, if any cell value is FALSE then return false otherwise then return true.
public class Solution2 {

    static Queue<Integer> queue = new LinkedList<>();

    public static boolean isConnected(int[][] adjMatrix, int vertices, int edges) {
        if (vertices ==0 && edges == 0) {
            return true;
        }

        boolean isConnected = true;
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        queue.add(vertices-1);
        traversedVertex[vertices-1] = true;
        bfTraversal(adjMatrix, traversedVertex, queue, vertices-1, 0);

        /////now loop and hceck in traversed or visited vertex array for any cell having value as 'FALSE'
        for (boolean visited: traversedVertex) {
            if(!visited) {
                isConnected=false; break;
            }
        }
        return isConnected;
    }

    private static void bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue, int vertexFrom, int vertexTo) {

        while (!queue.isEmpty()) {
            int currentVertex = (int) queue.poll();

            for (int i = adjMatrix.length - 1; i >= 0; i--) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    queue.add(i);
                    traversedVertex[i] = true;
                }

            }
        }
    }

}