package org.datastructure.java.tree.binarysearchtree.pairSumInABST;

import java.util.Vector;

public class Solution1 {
    /*
     * BinaryTreeNode class
     *
     * class BinaryTreeNode<T>
     * {
     * 		T data;
     * 		BinaryTreeNode<T> left;
     * 		BinaryTreeNode<T> right;
     *		public BinaryTreeNode(T data)
     *		{
     *  		this.data = data;
     *  	}
     *  }
     */

    static Vector<BinaryTreeNode<Integer>> treeNodes = new Vector<>();
    static Vector<Integer> vector = new Vector<>();

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        // Write your code here
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.data == s) System.out.println(root.data);
            else return;
        }

        arrangeNodeInAsc(root);

        int k=0;
        while (!treeNodes.isEmpty()) {
            BinaryTreeNode<Integer> node = treeNodes.remove(0);
            if( (node==root || root.right==node) && root.left==null) {
                if(!treeNodes.isEmpty())
                    root=treeNodes.firstElement();
                else
                    break;
            }
            nodeSumToS(node, root, s);
            k++;
        }

    }

    static BinaryTreeNode<Integer> arrangeNodeInAsc(BinaryTreeNode<Integer> root) {
        if (root == null) return null;

        arrangeNodeInAsc(root.left);
        if (root != null)
            treeNodes.add(root);
        arrangeNodeInAsc(root.right);

        return root;
    }

    static void nodeSumToS(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> bNode, int k) {
        if (bNode == null) return;
        if (root.data == bNode.data) return;

        if (root.data + bNode.data == k) {
            if (root.data > bNode.data)
                System.out.print(bNode.data + " " + root.data + "\n");
            else
                System.out.print(root.data + " " + bNode.data + "\n");
            return;
        }

        if (root.data >= bNode.data) return;

        nodeSumToS(root, bNode.left, k);
        nodeSumToS(root, bNode.right, k);
    }

}