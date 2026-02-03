package com.mycompany.mavenproject1.Trees.BinarySearchTree;

public class FlattenBinaryTreeToLL {

    /*
     * LeetCode 114 — Flatten Binary Tree to Linked List
     *
     * Given the root of a binary tree, flatten the tree into a linked list
     * in-place.
     * The linked list should follow preorder traversal (Root → Left → Right).
     *
     * After flattening:
     * - Each node's left pointer must be null.
     * - Each node's right pointer points to the next node in preorder.
     *
     * Do not create new nodes. Modify the tree in-place.
     */

    // Basic TreeNode structure
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /*
     * Recursive solution.
     *
     * Steps:
     * 1. Flatten left subtree
     * 2. Flatten right subtree
     * 3. Move left subtree to the right
     * 4. Attach original right subtree at the end
     */
    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        // Flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Move left subtree to right
        root.left = null;
        root.right = left;

        // Go to the end of the new right chain
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Attach original right subtree
        curr.right = right;
    }
}
