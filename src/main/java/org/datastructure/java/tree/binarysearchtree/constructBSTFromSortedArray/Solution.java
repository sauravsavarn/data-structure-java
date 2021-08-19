package org.datastructure.java.tree.binarysearchtree.constructBSTFromSortedArray;

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

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        if(arr.length==0)
            return null;
        if(arr.length==1)
            return new BinaryTreeNode<>(arr[0]);

        BinaryTreeNode<Integer> rootNode = SortedArrayToBST(arr, 0, arr.length-1, n);
        return rootNode;
    }

    static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int startIndex, int endIndex, int n){
        /////calculate mid-point
        //int midPoint = arr.length/2;
        //int midPoint = (endIndex-startIndex)/2;
        int midPoint = n/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[startIndex+midPoint]);

        if(midPoint==0)
            return root;

        root.left = SortedArrayToBST(arr, startIndex, startIndex+midPoint-1, (midPoint-0));
        root.right = SortedArrayToBST(arr, startIndex+midPoint+1, endIndex, startIndex+(arr.length-n));
        //root.right = SortedArrayToBST(arr, startIndex+midPoint+1, endIndex, (arr.length-midPoint));

        return root;
    }
}