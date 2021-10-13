package org.datastructure.java.graphs.getpathDFS;

import java.util.Stack;

public class Solution2 {
    private static Stack<Integer> stack = new Stack<>();

    public static void dfsTraversal(int[][] adjMatrix, int vertices, int edges, int vertexFrom, int vertexTo) {
        if (vertexTo > vertices - 1) return;
        if (edges == 0) {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " ");
            }
        }
        boolean[] traversedVertex = new boolean[adjMatrix.length];
        boolean isVertexToSmaller = false;
        if(vertexTo<vertexFrom) {
            int tmp=vertexFrom;
            vertexFrom=vertexTo;
            vertexTo = tmp;
            isVertexToSmaller=true;
        }
        traversedVertex[vertexTo] = true;
        stack.push(vertexTo);
        dfTraversal(adjMatrix, traversedVertex, vertexTo, vertexTo, vertexFrom, isVertexToSmaller);
    }

    private static void dfTraversal(int[][] adjMatrix, boolean[] traversedVertex, int currentVertex, int vertexFrom, int vertexTo, boolean isVertexToSmaller) {

        if (currentVertex == vertexTo) {
            ///now pop-up the Stack till the vertexTo
            String path = "";
            while (!stack.isEmpty()) {
                if(!isVertexToSmaller) {
                    int ele = stack.pop();
                    path = ele + " " + path;
                    //System.out.print(ele + " ");

                    if (ele == vertexFrom) {
                        System.out.println(path);
                        return;
                    }
                } else {
                    System.out.print(stack.pop() + " ");
                }
            }
            return;
        }


        for (int i = 0; i < adjMatrix[currentVertex].length; i++) {
            if (adjMatrix[currentVertex][i] != 0 && !traversedVertex[i]) {
                traversedVertex[i] = true;

                stack.push(i);
                dfTraversal(adjMatrix, traversedVertex, i, vertexFrom, vertexTo, isVertexToSmaller);
            }
        }

        return;
    }

}