package org.datastructure.java.tree.binarytree.maxNminInBinaryTree;

/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/



/*

	Representation of the Pair Class

	class Pair<T, U> {
		T minimum;
		U maximum;

		public Pair(T minimum, U maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}

*/

public class Solution {

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null)
            return null;

        Pair<Integer, Integer> pair1 = getMinAndMax(root.left);
        Pair<Integer, Integer> pair2 = getMinAndMax(root.right);

        if (pair1 != null && pair2 == null) {
            int minimum, maximum;
            maximum = Math.max(root.data, pair1.maximum);
            minimum = Math.min(root.data, pair1.minimum);

            return new Pair<>(minimum, maximum);
        }
        else if (pair1 == null && pair2 != null) {
            int minimum, maximum;
            maximum = Math.max(root.data, pair2.maximum);
            minimum = Math.min(root.data, pair2.minimum);

            return new Pair<>(minimum, maximum);
        } else if (pair1 != null && pair2 != null) {
            int minimum, maximum;
            maximum = Math.max(root.data, Math.max(pair1.maximum, pair2.maximum));
            minimum = Math.min(root.data, Math.min(pair1.minimum, pair2.minimum));

            return new Pair<>(minimum, maximum);
        } else if (pair1 == null && pair2 == null) {
            return new Pair<>(root.data, root.data);
        }

        return null;
    }

}