package org.datastructure.java.tree.generictree.secondLargestElementInTree;


import java.util.Collections;
import java.util.Vector;

public class Solution1 {

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


    static Vector<TreeNode<Integer>> vector = new Vector<>();

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        // Write your code here
        if (root == null) return null;

        /////first traverse trees in any order will be fine and insert the node data into Vector.
        traverseTree(root);

        ///////now using Comparator compare and sort the Vector element.
        Collections.sort(vector, (node1, node2) -> node1.data.compareTo(node2.data));

        //////////Thus the 2nd last element of Vector is the second Largest Element.
        int secondLargestIndex = 0;
        for (int i = vector.size() - 2; i >= 0; ) {
            if (vector.elementAt(i).data < vector.elementAt(vector.size()-1).data) {
                secondLargestIndex = i;
                break;
            }
            i--;
        }
        ////finally return the element.
        return vector.elementAt(secondLargestIndex);
    }

    private static void traverseTree(TreeNode<Integer> root) {
        if (root == null) return;

        for (int i = 0; i < root.children.size(); i++) {
            traverseTree(root.children.get(i));
        }
        vector.add(root);
    }
}
