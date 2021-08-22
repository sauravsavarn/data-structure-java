package org.datastructure.java.tree.generictree.nextLargerElement;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

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

    static Queue<TreeNode<Integer>> queue = new LinkedList<>();
    static TreeNode<Integer> nextLargestElement=null;
    static int diffRecentLargestElement=0;
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

        // Write your code here
        if (root == null) return null;

        ////
        queue.add(root); diffRecentLargestElement=Integer.MAX_VALUE;
        while (!queue.isEmpty()) {//now proceed to print level-wise.
            TreeNode<Integer> node = queue.poll();
            if (node.data > n) {
                if(diffRecentLargestElement>node.data-n) {
                    diffRecentLargestElement= node.data-n;
                    nextLargestElement=node;
                }
            }
            if (!node.children.isEmpty())
                for (int i = 0; i < node.children.size(); i++) {
                    TreeNode<Integer> child = node.children.get(i);
                    queue.add(child);
                }

        }
        ////
        if(nextLargestElement==null)return root;
        else return nextLargestElement;
    }
}