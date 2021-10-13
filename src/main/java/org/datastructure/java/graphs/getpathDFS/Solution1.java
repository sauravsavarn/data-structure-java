package org.datastructure.java.graphs.getpathDFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    static HashMap<Integer, Integer> mapChildParentRel = new HashMap<>(); ////holds childVertex & it's parentVertex.

    public static void dfsTraversal(int[][] adjMatrix, int vertices, int edges, int vertexFrom, int vertexTo) {
        if (vertexTo > vertices - 1) return;
        if (edges == 0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        mapChildParentRel.put(vertexTo, -1); ///Initially for vertexFrom there is no parent exists thus this is -1.
        traversedVertex[vertexTo] = true;
        dfTraversal(adjMatrix, traversedVertex, vertexTo, vertexFrom);

        ///////printing all the vertex.
        String output = "";
        while (true) {
            if (!mapChildParentRel.containsKey(vertexFrom)) break;
            int parent = mapChildParentRel.get(vertexFrom);
            //System.out.print(vertexFrom + " ");
            output = vertexFrom + " " + output;
            vertexFrom = parent;

            if (parent == -1) break;
        }
        System.out.println(output);
    }

    private static void dfTraversal(int[][] adjMatrix, boolean[] traversedVertex, int currentVertex, int vertexTo) {
        if (adjMatrix.length <= vertexTo || adjMatrix.length <= currentVertex) return;
        if (currentVertex == vertexTo || mapChildParentRel.containsKey(vertexTo)) return;

        for (int i = 0; i < adjMatrix[currentVertex].length; i++) {
            if (adjMatrix[currentVertex][i] != 0 && !traversedVertex[i]) {
                mapChildParentRel.put(i, currentVertex);
                traversedVertex[currentVertex] = true;
                if (i == vertexTo) {
                    return;
                }

                dfTraversal(adjMatrix, traversedVertex, i, vertexTo);
            }
        }
    }

}