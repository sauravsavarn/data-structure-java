package org.datastructure.java.tree.binarytree.levelwiseInputBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelwiseInputBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printBinaryTree(root);
    }

    /**
     * @param root
     */
    public static void printBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    /**
     * @return
     */
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root data : ");
        int rootData = scanner.nextInt();

        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.println("Enter left child of " + frontNode.data);
            int left = scanner.nextInt();

            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                frontNode.left = leftChild;
                queue.add(leftChild);
            }

            System.out.println("Enter right child of " + frontNode.data);
            int right = scanner.nextInt();

            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                frontNode.right = rightChild;
                queue.add(rightChild);
            }
        }

        /* ** ** */
        return root;
    }

}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
