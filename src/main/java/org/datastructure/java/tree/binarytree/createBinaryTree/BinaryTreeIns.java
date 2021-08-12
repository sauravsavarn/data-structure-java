package org.datastructure.java.tree.binarytree.createBinaryTree;

public class BinaryTreeIns<Integer> {
    private BinaryTree<Integer> binaryTreeRoot;

    public BinaryTreeIns(Integer data) {
        ///////creating BinaryTree with the root Node.
        binaryTreeRoot = new BinaryTree<>(data);
    }

    public void insBTreeChild(Integer data) {
        ///now iterate from Root Node of Tree to Insert the child at its right position
        boolean statusIns=false;
        BinaryTree<Integer> currNode = binaryTreeRoot;
        while(!statusIns) {
            if(currNode==null) {
                binaryTreeRoot = new BinaryTree<>(data);
                statusIns=true;
            } else {
                ///checks for values < root node of BinaryTree.
                if( java.lang.Integer.valueOf((java.lang.Integer) data) < java.lang.Integer.valueOf((java.lang.Integer) currNode.data)) {
                    if(currNode.leftChild!=null)
                        currNode=currNode.leftChild;
                    else {
                        BinaryTree<Integer> child = new BinaryTree<>(data);
                        currNode.leftChild=child;
                        currNode=currNode.leftChild;
                        statusIns=true;
                    }
                } else {
                    if(currNode.rightChild!=null)
                        currNode=currNode.rightChild;
                    else {
                        BinaryTree<Integer> child = new BinaryTree<>(data);
                        currNode.rightChild=child;
                        currNode=currNode.rightChild;
                        statusIns=true;
                    }
                }
            }
        }
    }

    public BinaryTree<Integer> getRootNode() {
        return this.binaryTreeRoot;
    }

    private void printBTreeIterative() {

    }

}
