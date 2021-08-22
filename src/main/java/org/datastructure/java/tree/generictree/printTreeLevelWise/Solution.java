package org.datastructure.java.tree.generictree.printTreeLevelWise;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

/*	TreeNode structure
 *
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

    static Queue<TreeNode<Integer>> queue = new LinkedList<>();

    public static void printLevelWise(TreeNode<Integer> root) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        if (root == null) return;

        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {//now proceed to print level-wise.
            TreeNode<Integer> node = queue.poll();
            if (node == null) {
                if (queue.peek() != null)
                    System.out.println();
                continue;
            }
            System.out.print(node.data + " ");
            if (!node.children.isEmpty())
                for (int i = 0; i < node.children.size(); i++) {
                    TreeNode<Integer> child = node.children.get(i);
                    queue.add(child);

                    if (queue.peek() == null)
                        if (i == node.children.size() - 1) queue.add(null);
                }
            else
                queue.add(null);
        }
    }
}

