package org.datastructure.java.tree.binarytree.pathSumRootToLeaf;

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

import java.util.*;

public class Solution {

    static int currVal=0;
    static int maxSum=0;
    static Stack<Integer> stack = new Stack();
    static List<ArrayList> path = new ArrayList<ArrayList>();

    static int totalSumInStack=0;
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        //Your code goes here
        if(root==null)
            return;

        pathSum(root,k);

        ///////now proceed with the printing of the solution
        int index=0;
        for (int i = 0; i < path.size(); i++) {
            ArrayList<Integer> aList = path.get(i);
            System.out.println(aList.toString().replaceAll("[,]", "").replace("[", "").replace("]", ""));
        }
    }

    public static void pathSum(BinaryTreeNode<Integer> root, int sum) {
        stack.push(root.data);

        if(root.left == null && root.right == null) {
            if(sum == root.data) path.add(new ArrayList<Integer>(stack));
        }

        if(root.left!=null) pathSum(root.left, sum-root.data);
        if(root.right!=null)pathSum(root.right, sum-root.data);

        stack.pop();
    }
}