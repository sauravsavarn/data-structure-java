package org.datastructure.java.tree.binarysearchtree.levelwiseLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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
    /*
     * LinkedListNode Class
     * class LinkedListNode<T>
     * {
     * 		T data;
     * 		LinkedListNode<T> next;
     * 		public LinkedListNode(T data)
     * 		{
     *  		this.data = data;
     *  	}
     *  }
     */
    static ArrayList<LinkedListNode<Integer>> alistOutput = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();
    static LinkedListNode<Integer> llTail = null;
    static LinkedListNode<Integer> llHead = null;

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null) return alistOutput;

        Node node = new Node(root, root, 'C', 1);
        queue.add(node);

        int currHeight = 1;
        while (!queue.isEmpty()) {
            Node interimNode = queue.poll();

            if (alistOutput.isEmpty()) {
                alistOutput.add(new LinkedListNode<>(interimNode.node.data));
            } else {
                /////if change in height found, then initiate new linked list and insert the data
                if (currHeight != interimNode.heightOfNode) { //////i.e. change in height is detected.
                    if (llHead != null)
                        alistOutput.add(llHead);
                    llHead = new LinkedListNode<>(interimNode.node.data);
                    llTail = llHead;
                    currHeight= interimNode.heightOfNode;
                } else {
                    llTail.next = new LinkedListNode<>(interimNode.node.data);
                    llTail = llTail.next;
                }
            }

            if (interimNode.node.left != null) {
                queue.add(new Node(interimNode.node.left, interimNode.node, 'L', interimNode.heightOfNode + 1));
            }
            if (interimNode.node.right != null) {
                queue.add(new Node(interimNode.node.right, interimNode.node, 'R', interimNode.heightOfNode + 1));
            }

            if(interimNode.node.left == null && interimNode.node.right==null && queue.size()==0) { //////i.e. the last node
                //////finally add this last node to the output provided llHead != NULL
                if (llHead != null)
                    alistOutput.add(llHead);
            }
        }

        return alistOutput;
    }

}

//////creating Node class object to hold related information to the Node at any level
class Node {
    BinaryTreeNode<Integer> node;
    BinaryTreeNode<Integer> root;
    char pos;
    int heightOfNode;

    public Node(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> root, char pos, int heightOfNode) {
        this.node = node;
        this.root = root;
        this.pos = pos;
        this.heightOfNode = heightOfNode;
    }
}