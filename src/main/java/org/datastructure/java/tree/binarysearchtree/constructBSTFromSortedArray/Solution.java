package org.datastructure.java.tree.binarysearchtree.constructBSTFromSortedArray;

import java.util.Arrays;

public class Solution {

	/*	Binary Tree Node class
	 *
	 * 	class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;

			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
		*/

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        if (arr.length == 0)
            return null;
        if (arr.length == 1)
            return new BinaryTreeNode<>(arr[0]);

        BinaryTreeNode<Integer> rootNode = SortedArrayToBST(arr);
        return rootNode;
    }

    static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
        if (arr.length == 0)
            return null;

        /////calculate mid-point
        int midPoint = (arr.length) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[midPoint]);

        if (midPoint == 0)
            return root;

        try {
            int[] leftArray = Arrays.copyOfRange(arr, 0, midPoint);
            root.left = SortedArrayToBST(leftArray);
        } catch (Exception e) {
            //
        }

        try {
            int[] rightArray = Arrays.copyOfRange(arr, midPoint + 1, arr.length);
            root.right = SortedArrayToBST(rightArray);
        } catch (Exception e) {
            //
        }

        return root;
    }
}