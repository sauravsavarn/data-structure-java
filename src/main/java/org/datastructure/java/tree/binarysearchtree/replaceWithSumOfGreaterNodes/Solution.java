package org.datastructure.java.tree.binarysearchtree.replaceWithSumOfGreaterNodes;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
     * right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */

    static Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    static Queue<NodeNIncVal> queueFinal = new LinkedList<>();
    static int total = 0;

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null || (root.left == null && root.right == null))
            return;

        queue.add(root);
        BinaryTreeNode<Integer> rootNode = root;
        BinaryTreeNode<Integer> rootNew = new BinaryTreeNode<>(-1);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> bNode = queue.poll();
            /////adding other connected to the queue
            if (bNode.left != null)
                queue.offer(bNode.left);
            if (bNode.right != null)
                queue.offer(bNode.right);

            total = 0;
            calculateLargerNodesSum(rootNode, bNode.data);

            //////push the calculated val along-with the node into queueFinal
            queueFinal.offer(new NodeNIncVal(bNode, total));
        }

        /////finally re-iterate through nodes and patching with their updated value.
        while(!queueFinal.isEmpty()) {
            NodeNIncVal objElement = queueFinal.poll();
            objElement.node.data=objElement.incValue;
        }

    }

    static int calculateLargerNodesSum(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return -1;

        calculateLargerNodesSum(root.left, data);
        calculateLargerNodesSum(root.right, data);

        if (data <= root.data) {
            total += root.data;
        }

        return total;
    }
}

/**
 *
 */
class NodeNIncVal {
    BinaryTreeNode<Integer> node;
    int incValue;

    NodeNIncVal(BinaryTreeNode<Integer> node, int incValue) {
        this.node = node;
        this.incValue = incValue;
    }
}