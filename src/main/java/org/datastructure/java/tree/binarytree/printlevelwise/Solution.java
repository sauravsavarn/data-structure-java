package org.datastructure.java.tree.binarytree.printlevelwise;

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
    ///declaring a queue to hold the level-wise node of the queue.
    static Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode<Integer> front= queue.poll();
            System.out.println(front.data+ ":L:"+ ((front.left!=null) ? front.left.data: -1) +",R:"+ (front.right!=null? front.right.data: -1) );
            if(front.left!=null)
                queue.add(front.left);
            if(front.right!=null)
                queue.add(front.right);
        }

        return;
    }

}