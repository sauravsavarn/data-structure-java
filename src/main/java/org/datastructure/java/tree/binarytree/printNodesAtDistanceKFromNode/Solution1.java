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
////////this Solution is Incomplete. Will try later for this approachs.
//////// Till Now - REFER SOLUTION 2 for correct and other way of problem solution approach and is correct.
public class Solution1 {
    static List<Integer> aList = new ArrayList<>();
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
        if(root==null)
            return;

        nodesAtKDistance(root, node, k, -1);
        aList.forEach(x -> System.out.println(x));
    }

    static void nodesAtKDistance(BinaryTreeNode<Integer> root, int node, int k, int currentLevel) {
        if(root==null || currentLevel>k)
            return;

        nodesAtKDistance(root.right, node, k, currentLevel);

        if(k==currentLevel)
            aList.add(root.data);

        if(root.data==node) {
            currentLevel = 0;
        }
        if(currentLevel>=0) {
            currentLevel+=1;
        }

        System.out.println("ROOT_NODE : " + root.data + " - CURRENT_LEVEL : " + currentLevel);
        nodesAtKDistance(root.left, node, k, currentLevel);

    }

}