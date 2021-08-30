package org.datastructure.java.testrounds.checkCousions;


public class Solution1 {

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

        boolean output = true;
        checkForCousions(root, p, q, 1);
        if (heightOfP != heightOfQ)
            output = false;
        if (rootOfP == rootOfQ)
            output = false;

        return output;
    }

    static int heightOfP = 0;
    static int heightOfQ = 0;
    static BinaryTreeNode<Integer> rootOfP = null;
    static BinaryTreeNode<Integer> rootOfQ = null;

    static void checkForCousions(BinaryTreeNode<Integer> root, int p, int q, int heightOfNode) {
        if (root == null) return;

        if ((root.left != null && root.left.data == p) || (root.right != null && root.right.data == p)) {
            rootOfP = root;
        }
        if ((root.left != null && root.left.data == q) || (root.right != null && root.right.data == q)) {
            rootOfQ = root;
        }

        if (rootOfQ != null && rootOfP != null) {
            //return;
        }

        checkForCousions(root.left, p, q, heightOfNode + 1);
        checkForCousions(root.right, p, q, heightOfNode + 1);


        if (root.data == p) {
            heightOfP = heightOfNode;
        }
        if (root.data == q) {
            heightOfQ = heightOfNode;
        }
    }
}
