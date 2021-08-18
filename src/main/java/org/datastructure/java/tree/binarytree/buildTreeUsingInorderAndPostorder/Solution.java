package org.datastructure.java.tree.binarytree.buildTreeUsingInorderAndPostorder;

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

public class Solution {

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        //Your code goes here
        int root=-1; int[] leftInorder; int[] rightInorder; int[] leftPostorder; int[] rightPostorder;

        //Your code goes here
        if(postOrder.length<3)
            return null;
        if(inOrder.length==1)
            return new BinaryTreeNode<>(inOrder[0]);

        root=postOrder[2];

        int k=1;
        for (int ele: inOrder) {
            if(ele==root)
                break;
            k++;
        }
        //////////>>>>>>>SEGREGATING IN-ORDER ARRAY INTO leftInorder & rightInorder : START
        /////finalizing size of array
        leftInorder = new int[k-1];
        rightInorder = new int[inOrder.length-k];
        /////
        for (int i = 0; i < k-1; i++) {
            leftInorder[i]=inOrder[i];
        }
        int l=0;
        for (int i = k; i < inOrder.length; i++) {
            rightInorder[l++]=inOrder[i];
        }
        //////////>>>>>>>SEGREGATING IN-ORDER ARRAY INTO leftInorder & rightInorder : END

        //////////>>>>>>>SEGREGATING PRE-ORDER ARRAY INTO leftPreorder & rightPreorder : START
        /////finalizing size of array
        leftPostorder = new int[leftInorder.length];
        rightPostorder = new int[rightInorder.length];
        /////
        for (int i = 0; i < leftInorder.length; i++) {
            leftPostorder[i]=postOrder[i+1];
        }
        l=0;
        for (int i = (leftPostorder.length+1); i < postOrder.length; i++) {
            rightPostorder[l++]=postOrder[i];
        }
        //////////>>>>>>>SEGREGATING PRE-ORDER ARRAY INTO leftPreorder & rightPreorder : END

        //////Finally, call Recursion for both leftInorder & rightInorder & then attaching it to the root
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(root);
        rootNode.left=buildTree(leftPostorder, leftInorder);
        rootNode.right=buildTree(rightPostorder, rightInorder);

        return rootNode;
    }

}