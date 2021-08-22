package org.datastructure.java.tree.generictree.numberOfNodesGreaterThanX;

public class Solution {

/*	TreeNode class
 *
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

    static int totalNumOfNodes=0;
    public static int numNodeGreater(TreeNode<Integer> root,int x){

        // Write your code here
        if(root==null)return totalNumOfNodes;

        if(root.data>x) totalNumOfNodes+=1;

        for (int i = 0; i < root.children.size(); i++) {
            numNodeGreater(root.children.get(i), x);
        }

        return totalNumOfNodes;
    }

}
