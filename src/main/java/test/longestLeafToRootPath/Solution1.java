package test.longestLeafToRootPath;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {

/*	Binary Tree Node class
 *
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/

    static int longestPath = Integer.MIN_VALUE;
    static ArrayList<Integer> aList = new ArrayList<>();

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null) return null;
        ArrayList<Integer> interimList = new ArrayList<>();
        longestPathToLeaf(root, 1, interimList, root);
        System.out.println("testing");
        return interimList;
    }

    static ArrayList<Integer> longestPathToLeaf(BinaryTreeNode<Integer> node, int height, ArrayList<Integer> interimList,
                                                BinaryTreeNode<Integer> root) {
        if (node == null) return interimList;

        ArrayList<Integer> alistLeft = longestPathToLeaf(node.left, height + 1, interimList, root);
        interimList.add(node.data);
        ArrayList<Integer> interimListRt = new ArrayList<>(interimList.size() + 1);
        if (node.right != null) {
            for (int lstElement : alistLeft) {
                interimListRt.add(lstElement);
            }
        }
        //Collections.copy(interimListRt, interimList);
        ArrayList<Integer> alistRight = longestPathToLeaf(node.right, height + 1, interimListRt, root);

//        if (node.data == root.data) {
//            interimList.add(node.data);
//            return interimList;
//        }

        if (alistLeft.size() > alistRight.size()) return alistLeft;
        else return alistRight;
    }

    static void longestPathToLeaf1(BinaryTreeNode<Integer> node, int height, BinaryTreeNode<Integer> root) {
        if (node == null) return;

        longestPathToLeaf1(node.left, height + 1, root);

        if (node.data == root.data) {
            aList.add(node.data);
            return;
        }
        longestPathToLeaf1(node.right, height + 1, root);

        if (longestPath < height) {
            longestPath = height;
            aList.clear();
        }
        aList.add(node.data);

    }

}