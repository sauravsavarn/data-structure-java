package org.datastructure.java.tree.binarytree.buildTreeUsingInorderAndPostorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    int[] postOrder;
    int[] inOrder;

    public Pair(int[] postOrder, int[] inOrder) {
        this.postOrder = postOrder;
        this.inOrder = inOrder;
    }

}

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int pre[] = new int[n];
        int in[] = new int[n];

        String[] postOrder = br.readLine().trim().split(" ");
        String[] inOrder = br.readLine().trim().split(" ");


        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(postOrder[i].trim());
            in[i] = Integer.parseInt(inOrder[i].trim());
        }

        return new Pair(pre, in);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();


            if (frontNode == null) {
                System.out.println();

                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }

            } else {
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }

                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }

        }

    }
    public static void main(String[] args) throws NumberFormatException, IOException {

        Pair input = takeInput();

        int[] postOrder = input.postOrder;
        int[] inOrder = input.inOrder;

        BinaryTreeNode<Integer> root = Solution.buildTree(postOrder, inOrder);

        printLevelWise(root);

    }
}
