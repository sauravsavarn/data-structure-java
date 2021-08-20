package org.datastructure.java.tree.binarysearchtree.elementsBetweenK1NK2;

public class Solution1 {

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
    static int lowerIndex=0;
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null)
            return;

        int tmp = 0;
        if (k1 > k2) {
            tmp = k1;
            k1 = k2;
            k2 = tmp;
            lowerIndex=k1;
        }
        if (root.data < k2 && root.data > k1) {
            lowerIndex=k1;
            elementInRange(root, root.data - 1);
            lowerIndex= root.data;
            elementInRange(root, k2);
        } else {
            lowerIndex=k1;
            elementInRange(root, k2);
        }
    }

    static void elementInRange(BinaryTreeNode<Integer> root, int k2) {
        if (root == null)
            return;

        if (root.data > lowerIndex) {
            elementInRange(root.left, k2);
        }
        ///////
        if(root.data == k2) {
            System.out.print(root.data + " ");
            return;
        } else if (root.data == lowerIndex) {
            System.out.print(root.data + " ");
            lowerIndex += 1;
            //return;
        }
        ///////

        if (root.data <= lowerIndex) {
            elementInRange(root.right, k2);
        }

        return;
    }


}