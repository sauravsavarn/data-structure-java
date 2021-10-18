package org.datastructure.java.graphs.getpathDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {


    public static void dfsTraversal(int[][] adjMatrix, int vertices, int edges, int vertexFrom, int vertexTo) {
        if (vertexTo > vertices - 1) return;
        if (edges == 0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        ArrayList<Integer> ans = getPathBFS(adjMatrix, traversedVertex, vertexFrom, vertexTo);
        if (ans != null) {
            for (int elem : ans) {
                System.out.print(elem + " ");
            }
        }
    }

    public static ArrayList<Integer> getPathBFS(int[][] edges, boolean[] visited, int V1, int V2) {
        if (V1 == V2) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(V1);
            visited[V1] = true;
            return ans;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> h = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(V1);
        visited[V1] = true;
        while (!q.isEmpty()) {
            int first = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[first][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    h.put(i, first);
                    if (i == V2) {
                        ans.add(i);
                        while (!ans.contains(V1)) {

                            int b = h.get(i);
                            ans.add(b);
                            i = b;
                        }
                        return ans;
                    }
                }
            }


        }


        return null;
    }

}