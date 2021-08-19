package org.datastructure.java.tree.binarytree.printNodesAtDistanceKFromNode;


/*

	Following is the structure used to represent the Binary Tree Node

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

*/

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static List<Integer> aList = new ArrayList<>();
    static List<BinaryTreeNode<Integer>> alistOfNodes = new ArrayList<>();

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
        if (root == null)
            return;

        ////first find all nodes to the node from the root node.
        recordAllNodesToTargetNode(root, node);

        for (int i = 0; i < alistOfNodes.size(); i++) {
            nodesAtKDistance(alistOfNodes.get(i), i,k-i, 0);
        }

        aList.forEach(x -> System.out.println(x));
    }

    static boolean isFound = false;

    private static void recordAllNodesToTargetNode(BinaryTreeNode<Integer> root, int node) {
        if (root == null)
            return;
        if (isFound)
            return;

        if (root.data == node) {
            alistOfNodes.add(root);
            isFound = true;
            return;
        }

        recordAllNodesToTargetNode(root.left, node);
        recordAllNodesToTargetNode(root.right, node);

        if (isFound)
            alistOfNodes.add(root);
    }

    /**
     *
     * @param root
     * @param index - current index of alistOfNodes
     * @param k - depth to search from the passed node as parameter
     * @param currentLevel
     */
    static void nodesAtKDistance(BinaryTreeNode<Integer> root, int index, int k, int currentLevel) {
        if (root == null || currentLevel > k)
            return;

        if (k == currentLevel)
            aList.add(root.data);

        //System.out.println("ROOT_NODE : " + root.data + " - CURRENT_LEVEL : " + currentLevel);
        if(currentLevel==0 && index!=0 &&
                alistOfNodes.get(index).left == alistOfNodes.get(index-1)) {
            nodesAtKDistance(root.right, index, k, currentLevel+1);
            return;
        } else if(currentLevel==0 && index!=0 &&
                alistOfNodes.get(index).right == alistOfNodes.get(index-1)) {
            nodesAtKDistance(root.left, index, k, currentLevel+1);
            return;
        }
        nodesAtKDistance(root.left, index, k, currentLevel+1);
        nodesAtKDistance(root.right, index, k, currentLevel+1);

    }

}