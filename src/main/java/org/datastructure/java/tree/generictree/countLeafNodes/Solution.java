package org.datastructure.java.tree.generictree.countLeafNodes;

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

    static int leafNodesCount=0;
    public static int countLeafNodes(TreeNode<Integer> root){

        // Write your code here
        if(root==null) return 0;

        if(root.children.isEmpty()) leafNodesCount+=1;
        for (int i = 0; i < root.children.size(); i++) {
            countLeafNodes(root.children.get(i));
        }

        return leafNodesCount;
    }

}
