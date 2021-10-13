package org.datastructure.java.graphs.getpathBFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static HashMap<Integer, Integer> mapChildParentRel = new HashMap<>(); ////holds childVertex & it's parentVertex.

    public static void bfsTraversal(int[][] adjMatrix, int vertices, int edges, int vertexFrom, int vertexTo) {
        if(vertexTo>vertices-1) return;
        if (edges == 0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        mapChildParentRel.put(vertexTo, -1); ///Initially for vertexFrom there is no parent exists thus this is -1.
        queue.add(vertexTo);
        traversedVertex[vertexTo] = true;
        bfTraversal(adjMatrix, traversedVertex, queue, vertexFrom);

        ///////printing all the vertex.
        String output = "";
        while (true) {
            if(!mapChildParentRel.containsKey(vertexFrom)) break;
            int parent = mapChildParentRel.get(vertexFrom);
            //System.out.print(vertexFrom + " ");
            output = vertexFrom + " " + output;
            vertexFrom = parent;

            if(parent==-1) break;
        }
        System.out.println(output);
    }

    private static void bfTraversal(int[][] adjMatrix, boolean[] traversedVertex, Queue queue, int vertexTo) {

        int currentVertex = -1;
        boolean isVertextToExists = false;
        while (!queue.isEmpty()) {

            currentVertex = (int) queue.poll();
            boolean isConnected = false;
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !traversedVertex[i]) {
                    //i is unvisited neighbour of currentVertex
                    mapChildParentRel.put(i, currentVertex); /////mapping child & it's parent relation.
                    queue.add(i);
                    traversedVertex[i] = true;

                    if (i == vertexTo) {
                        isVertextToExists = true;
                        break;
                    }
                }
            }

            if (isVertextToExists) break;
        }
    }
}