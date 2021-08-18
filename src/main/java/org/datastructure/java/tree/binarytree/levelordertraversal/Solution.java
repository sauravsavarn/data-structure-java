package org.datastructure.java.tree.binarytree.levelordertraversal;

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


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ///declaring queue to support levelwise traversal
    static Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null)
            return;

        queue.add(root);
        queue.add(null);
        int k=0;
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> front = queue.poll();
            if (front == null) {
                System.out.println();
                if(k>1 && queue.peek()!=null)
                    queue.add(null);
                k++;
                continue;
            } else
                System.out.print(front.data+ " ");

            if (front.left != null)
                queue.add(front.left);
            if (front.right != null) {
                queue.add(front.right);
                if(k==0) {
                    queue.add(null);
                    k++;
                }
            }
        }

        return;
    }
}