package org.datastructure.java.tree.generictree.secondLargestElementInTree;

//////Solution2 is the most optimal Solution
public class Solution2 {

/*	TreeNode structure
 *
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

    // Pointers to store the largest and second largest node
    public static TreeNode<Integer> largest;
    public static TreeNode<Integer> secondLargest;

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        // Write your code here
        if (root == null) return null;

        // Initialising the pointers to a node with value negative infinity
        largest = new TreeNode<Integer>(Integer.MIN_VALUE);
        secondLargest = largest;

        findSecondLargestHelper(root);
        return secondLargest;
    }

    // Helper Function to find the second largest node of the n-ary tree
    public static void findSecondLargestHelper(TreeNode<Integer> root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Check if root's data is larger than current largest node's data
        if (root.data > largest.data) {
            secondLargest = largest;
            largest = root;
        } else if (root.data > secondLargest.data && root.data != largest.data)
            secondLargest = root;

        // recursively find second largest in children
        for (TreeNode<Integer> child : root.children)
            findSecondLargestHelper(child);
    }
}
