package org.datastructure.java.tree.binarytree.printBinaryTreeRecursively;

import org.datastructure.java.tree.binarytree.createBinaryTree.BinaryTree;

import java.util.Vector;

public class PrintBTreeRecursively<T> {
    private BinaryTree<T> binaryTreeRoot;

    public PrintBTreeRecursively(BinaryTree<T> binaryTreeRoot) {
        this.binaryTreeRoot = binaryTreeRoot;
    }

    public Vector<T> print() {
        Vector<T> output = new Vector<>();

        if (binaryTreeRoot == null) return null;
        else {
            BinaryTree<T> currRootNode = binaryTreeRoot;
            return printRecursively(output, currRootNode);
        }
    }

    private Vector<T> printRecursively(Vector<T> output, BinaryTree<T> currNode) {
        if (currNode.leftChild == null && currNode.rightChild == null) {
            output.add(currNode.data);
            return output;
        }

        if(currNode.leftChild!=null)
            printRecursively(output, currNode.leftChild);
        if(currNode.rightChild!=null)
            printRecursively(output, currNode.rightChild);

        output.add(currNode.data);
        return output;
    }
}
