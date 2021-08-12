package org.datastructure.java.tree.binarytree.sumofnodes;

/*

	Following is the Binary Tree Node class structure.

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

import org.datastructure.java.tree.binarytree.createBinaryTree.BinaryTree;

import java.util.Vector;

public class Solution {
    static int sum = 0;

    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here.
        return sumRecursively1(root);
        //return sumRecursively2(root);////another simpler way to get sum using Recursion
    }

    private static int sumRecursively1(BinaryTreeNode<Integer> currNode) {
        if (currNode.left == null && currNode.right == null) {
            sum += currNode.data;
            return sum;
        }

        if (currNode.left != null)
            sumRecursively1(currNode.left);
        if (currNode.right != null)
            sumRecursively1(currNode.right);

        sum += currNode.data;
        return sum;
    }

    private static int sumRecursively2(BinaryTreeNode<Integer> currNode) {
        if (currNode == null) return 0;

        int leftNodeCount = sumRecursively1(currNode.left);
        int rightNodeCount = sumRecursively1(currNode.right);
        sum += leftNodeCount + rightNodeCount + 1;
        return sum;
    }

}