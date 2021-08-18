package org.datastructure.java.tree.binarytree.buildTreeUsingInorderAndPreorder;

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

//    static int root=-1;
//    static int[] leftInorder;
//    static int[] rightInorder;
//    static int[] leftPreorder;
//    static int[] rightPreorder;
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int root=-1; int[] leftInorder; int[] rightInorder; int[] leftPreorder; int[] rightPreorder;

        //Your code goes here
        if(preOrder.length==0)
            return null;
        if(inOrder.length==1)
            return new BinaryTreeNode<>(inOrder[0]);

        root=preOrder[0];

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
        leftPreorder = new int[leftInorder.length];
        rightPreorder = new int[rightInorder.length];
        /////
        for (int i = 0; i < leftInorder.length; i++) {
            leftPreorder[i]=preOrder[i+1];
        }
        l=0;
        for (int i = (leftPreorder.length+1); i < preOrder.length; i++) {
            rightPreorder[l++]=preOrder[i];
        }
        //////////>>>>>>>SEGREGATING PRE-ORDER ARRAY INTO leftPreorder & rightPreorder : END

        //////Finally, call Recursion for both leftInorder & rightInorder & then attaching it to the root
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(root);
        rootNode.left=buildTree(leftPreorder, leftInorder);
        rootNode.right=buildTree(rightPreorder, rightInorder);

        return rootNode;
    }

}