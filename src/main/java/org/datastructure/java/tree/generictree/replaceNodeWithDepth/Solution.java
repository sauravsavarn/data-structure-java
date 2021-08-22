package org.datastructure.java.tree.generictree.replaceNodeWithDepth;

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

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here
        if(root==null)return;

        replaceNodeWithItsDepth(root, 0);
    }

    static void replaceNodeWithItsDepth(TreeNode<Integer> root, int depth) {
        for (int i = 0; i < root.children.size(); i++) {
            replaceNodeWithItsDepth(root.children.get(i), depth+1);
        }
        root.data=depth;
    }
}
