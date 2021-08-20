package org.datastructure.java.tree.binarysearchtree.findPathInBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> {
     * 		T data;
     * 		BinaryTreeNode<T> left;
     * 		BinaryTreeNode<T> right;
     * 		public BinaryTreeNode(T data)
     * 		{
     * 			this.data = data;
     * 		}
     * }
     */

    static List<Integer> aListPath = new ArrayList<>();
    static boolean isFound = false;

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (root == null)
            return (ArrayList<Integer>) aListPath;

        if (root.data == data) {
            isFound = true;
            aListPath.add(data);
            return (ArrayList<Integer>) aListPath;
        }

        if (root.data > data)
            getPath(root.left, data);
        else
            getPath(root.right, data);

        if (isFound)
            aListPath.add(root.data);
        return (ArrayList<Integer>) aListPath;
    }
}
