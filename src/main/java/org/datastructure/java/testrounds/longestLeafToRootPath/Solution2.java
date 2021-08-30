package org.datastructure.java.testrounds.longestLeafToRootPath;

import java.util.ArrayList;

public class Solution2 {

/*	Binary Tree Node class
 *
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/

    static int longestPath = 0;
    static ArrayList<Integer> aList = new ArrayList<>();

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        // Write your code here

        // If root is null means there is no binary tree so return a empty vector
        if(root == null)
        {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }

        // Recursive call on root.right
        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        // Recursive call on root.left
        ArrayList<Integer> left = longestRootToLeafPath(root.left);

        // Compare the size of the two ArrayList
        // and insert current node accordingly
        if(right.size() < left.size())
        {
            left.add(root.data);
        }
        else
        {
            right.add(root.data);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left :right);
    }

}