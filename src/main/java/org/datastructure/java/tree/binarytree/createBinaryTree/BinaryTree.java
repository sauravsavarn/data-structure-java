package org.datastructure.java.tree.binarytree.createBinaryTree;

/**
 * Binary Tree template
 * @param <T>
 */
public class BinaryTree<T> {
    public T data;
    public BinaryTree<T> leftChild;
    public BinaryTree<T> rightChild;

    public BinaryTree(T data) {
        this.data=data;
    }
}
