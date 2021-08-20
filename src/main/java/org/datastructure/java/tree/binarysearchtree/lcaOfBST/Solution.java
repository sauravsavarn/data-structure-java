package org.datastructure.java.tree.binarysearchtree.lcaOfBST;

import java.util.Vector;

public class Solution {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */

    static int lca = 0;
    static Vector<Integer> v1 = new Vector<>();
    static Vector<Integer> v2 = new Vector<>();

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null)
            return -1;


        lcaGet(root, root.data, a, v1);
        lcaGet(root, root.data, b, v2);

        //////now search for the element just before b in vector 2 & also check for this element
        //////in vector v1, if found this is the answer or otherwise -1 to be returned.
        int data = 0;
        if (v2.indexOf(b) == -1)
            return -1;
        else if ((v2.size() == 1 && v1.size() == 1))
            data = v2.get(0);
        else {
            for (int i = v2.size() - 1; i >= 0; i--) {
                if (v1.size() == 0) {
                    data = -1;
                    break;
                }
                if (v1.indexOf(v2.elementAt(i)) != -1) //////check for this data into Vector v1 and or return otherwise.
                    data = v2.elementAt(i);
                else
                    break;
            }
        }

        return data;
    }

    static boolean statusTracked = false;

    static void lcaGet(BinaryTreeNode<Integer> root, int rootData, int x, Vector<Integer> v) {
        if (root == null)
            return;

        if (x < root.data)
            lcaGet(root.left, rootData, x, v);
        if (x >= root.data) {
            if (x == root.data) {
                statusTracked = true;
                v.add(root.data);
                return;
            }
            lcaGet(root.right, rootData, x, v);
        }

        if (statusTracked) {
            v.add(root.data);
        }
    }
}