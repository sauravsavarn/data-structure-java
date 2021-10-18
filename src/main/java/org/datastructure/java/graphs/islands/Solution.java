package org.datastructure.java.graphs.islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static Queue<Integer> queue = new LinkedList<>();

    public static int numConnected(int[][] edges, int n) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int vertices = n;
        int totalEdges = edges.length;

        return countConnected(edges, vertices, totalEdges);
    }

    public static int countConnected(int[][] adjMatrix, int vertices, int edges) {
        if (vertices == 0 && edges == 0) {
            return 0;
        }

        int countConnectedIslands = 0;
        int vertex = vertices - 1;//////Initially pick the last Vertex.
        boolean[] traversedVertex = new boolean[vertices];//adjMatrix.length];
        while (true) {
            boolean statusAllVerticesVisited = false;
            queue.add(vertex);
            traversedVertex[vertex] = true;
            boolean isConnected = bfTraversal(adjMatrix, traversedVertex, queue, vertex, 0);

            if (isConnected) countConnectedIslands += 1; /////increase Island count by 1.
            else if (!isConnected) {
                countConnectedIslands += 1;
                //vertex = vertex - 1;

                if (vertex < 0) break;
            }

            /////now loop and check in traversed or visited vertex array for any cell having value as 'FALSE'
            //if (isConnected)
            for (int i = traversedVertex.length - 1; i >= 0; i--) {
                if (traversedVertex[i] == false) {
                    vertex = i; /////this time add this un-visited vertex to the queue.
                    break;
                }

                if (i == 0) {
                    statusAllVerticesVisited = true;
                }
            }

            if (statusAllVerticesVisited) break;
        }

        return countConnectedIslands;
    }

    private static boolean bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue, int vertexFrom, int vertexTo) {

        boolean isGraphConnected = false;
        while (!queue.isEmpty()) {
            int currentVertex = (int) queue.poll();

           /* if (vertexTo == currentVertex) {
                isGraphConnected = true;
                return true; //////this graph is connected
            }*/

            for (int i = adjMatrix.length - 1; i >= 0; i--) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    queue.add(i);
                    traversedVertex[i] = true;
                }

            }
        }

        return isGraphConnected;
    }
}