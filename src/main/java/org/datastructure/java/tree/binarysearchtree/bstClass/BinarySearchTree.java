package org.datastructure.java.tree.binarysearchtree.bstClass;

/*
 * Binary Tree Node class
 *
 * class BinaryTreeNode<T> {
 * 		T data;
 * 		BinaryTreeNode<T> left;
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data)
 * 		{
 * 			this.data = data;
 * 		}
 * }
 */

/*
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */
class BSTHelper {
    private BSTHelper() {
    }

    public static void insert(BinaryTreeNode<Integer> root, int data, char pos, BinaryTreeNode<Integer> btree) {
        if (root == null) {
            if (pos == 'L')
                btree.left = new BinaryTreeNode<>(data);
            else
                btree.right = new BinaryTreeNode<>(data);

            return;
        }

        if (root.data >= data)
            insert(root.left, data, 'L', root);
        else
            insert(root.right, data, 'R', root);
    }

    public static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data, char pos, BinaryTreeNode<Integer> rootParent) {
        if (root == null) return null;

        if (root.data == data) { ////remove root element and now right of root will become the new root.
            if (root.right != null) {
                //root.right.left = root.left;
                if (pos == 'C') {
                    BinaryTreeNode<Integer> interimRootNode = root.right;
                    interimRootNode.left = root.left;
                    return interimRootNode;
                }
                if (rootParent != root) {
                    if (pos == 'L') {
                        rootParent.left = root;
                    } else {
                        rootParent.right = root;
                    }
                }
            } else {
                if(pos == 'C') {
                    BinaryTreeNode<Integer> interimRootNode = root.left;
                    return interimRootNode;
                }
                if (pos == 'L') {
                    rootParent.left = root.left;
                } else {
                    rootParent.right = root.left;
                }
            }

            return root;
        }

        if (root.data >= data)
            root.left = remove(root.left, data, 'L', root);
        else
            root.right = remove(root.right, data, 'R', root);

        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.println(root.data + ":" + (root.left != null ? "L:" + root.left.data + "," : "") + (root.right != null ? "R:" + root.right.data : ""));
        printTree(root.left);
        printTree(root.right);
    }

    public static boolean search(BinaryTreeNode<Integer> root, int data) {
        if (root == null) return false;

        if (root.data == data)
            return true;

        if (root.data > data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }
}

public class BinarySearchTree {
    private static BinaryTreeNode<Integer> root = null;

    public void insert(int data) {
        //Implement the insert() function
        if (root == null)
            root = new BinaryTreeNode<>(data);
        else
            BSTHelper.insert(root, data, 'C', root);
    }

    public void remove(int data) {
        //Implement the remove() function
        root = BSTHelper.remove(root, data, 'C', root);
    }

    public void printTree() {
        //Implement the printTree() function
        BSTHelper.printTree(root);
    }

    public boolean search(int data) {
        //Implement the search() function
        return BSTHelper.search(root, data);
    }


}