package org.datastructure.java.tree.generictree.nodesHavingSumOfChildrenNNodeIsMax;


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

    static int maxValue=0, interimValue=0;
    static TreeNode<Integer> maxValuedTreeNode=null;
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        if (root == null) return null;

        if (!root.children.isEmpty()) {
            ///switch to children and it's children
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode<Integer> integerTreeNode = maxSumNode(root.children.get(i));
                //if(integerTreeNode!=null) interimValue=integerTreeNode.data;
            }

            ////summing up root's & it's children values
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode<Integer> interimTreeNode = maxSumNode(root.children.get(i));
                if(interimTreeNode!=null)
                    interimValue+=interimTreeNode.data;
                if(i==root.children.size()-1) {
                    interimValue+=root.data;
                    if(interimValue>maxValue) {
                        maxValue = interimValue;
                        maxValuedTreeNode = root;
                        interimValue=0;
                    } else {
                        interimValue=0;
                    }
                }
            }

        } else {
            return root;
        }

        return maxValuedTreeNode;
    }


}
