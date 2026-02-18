package com.mycompany.mavenproject1.Trees.BinarySearchTree;

public class isBST {

    /*
     * Given a binary tree with N number of nodes, check if that input tree is BST
     * (Binary Search Tree). If yes, return true, return false otherwise.
     * 
     * Note:
     * Duplicate elements should be kept in the right subtree.
     * 10
     * / \
     * 5 15
     * / \ \
     * 2 7 20
     */
    // This only compares immediate children.
    // But BST rules are global, not local.

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBstHelper(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (!(root.data > min && root.data < max)) {
            return false;
        }

        return (isBstHelper(root.left, min, root.data) && isBstHelper(root.right, root.data, max));

    }
}
