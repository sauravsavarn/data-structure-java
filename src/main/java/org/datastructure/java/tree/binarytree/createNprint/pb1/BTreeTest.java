package org.datastructure.java.tree.binarytree.createNprint.pb1;

import org.datastructure.java.tree.binarytree.createBinaryTree.BinaryTreeIns;
import org.datastructure.java.tree.binarytree.printBinaryTreeRecursively.PrintBTreeRecursively;

import java.util.Enumeration;
import java.util.Vector;

////To check for the BinaryTree Insertion and then once Insertion is done proceed to print recursively.
public class BTreeTest {
    static BinaryTreeIns<Integer> bTreeIns;
    static PrintBTreeRecursively<Integer> bTreePrint;
    public static void main(String[] args) {

        ///////Insertion of default values into Binary-Tree.
        bTreeIns = new BinaryTreeIns<Integer>(50);
        bTreeIns.insBTreeChild(45);
        bTreeIns.insBTreeChild(25);
        bTreeIns.insBTreeChild(35);
        bTreeIns.insBTreeChild(75);
        bTreeIns.insBTreeChild(7);
        bTreeIns.insBTreeChild(10);
        bTreeIns.insBTreeChild(10);
        bTreeIns.insBTreeChild(100);
        bTreeIns.insBTreeChild(90);
        bTreeIns.insBTreeChild(1);

        /////////Finally call to print the Binary-Tree.
        bTreePrint=new PrintBTreeRecursively<>(bTreeIns.getRootNode());
        Vector<Integer> output = bTreePrint.print();

        Enumeration enumeration = output.elements();
        while(enumeration.hasMoreElements()) {
            System.out.print((int)enumeration.nextElement() + " ");
        }

    }


}
