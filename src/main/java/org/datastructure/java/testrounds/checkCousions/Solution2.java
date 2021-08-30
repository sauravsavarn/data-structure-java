package org.datastructure.java.testrounds.checkCousions;


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
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // Write your code here
        if (root == null) return true;

        boolean output = checkForCousions(root, p, q);


        return output;
    }

    static boolean checkForCousions(BinaryTreeNode<Integer> node, int a, int b)
    {
        // 1. The two Nodes should be on the same level
        //       in the binary tree.
        // 2. The two Nodes should not be siblings (means
        //    that they should not have the same parent
        //    Node).
        return ((level(node, a, 1) == level(node, b, 1)) &&
                (!isSibling(node, a, b)));
    }

    // Recursive function to find level of Node 'ptr' in
    // a binary tree
    static int level(BinaryTreeNode<Integer> node, int a, int lev)
    {
        // base cases
        if (node == null)
            return 0;

        if (node.data == a)
            return lev;

        // Return level if Node is present in left subtree
        int l = level(node.left, a, lev + 1);
        if (l != 0)
            return l;

        // Else search in right subtree
        return level(node.right, a, lev + 1);
    }

    // Recursive function to check if two Nodes are
    // siblings
    static boolean isSibling(BinaryTreeNode<Integer> node, int a, int b)
    {
        // Base case
        if (node == null)
            return false;

        return ( (node.left!=null && node.right!=null && node.left.data == b && node.right.data == a) ||
                (node.left!=null && node.right!=null && node.left.data == a && node.right.data == b) ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b));
    }
}
