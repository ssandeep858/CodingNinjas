package com.mycompany.mavenproject1.Trees.BinaryTrees;

/*Given a binary tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the binary tree.
LCA
LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 

*/
public class LCA {

    // ✅ This is the main function that calls the helper.
    // If LCA is not found, it returns -1. Otherwise, it returns the data of the LCA
    // node.
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> lca = getLCAHelper(root, a, b);
        return (lca == null) ? -1 : lca.data;
    }

    // ✅ This helper function does the actual recursive work.
    // It returns the LCA node if both nodes are found in the tree.
    public static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b) {

        // 📌 Base Case: If we reach a null node, there's nothing to check.
        if (root == null) {
            return null;
        }

        // 📌 If the current node matches either a or b,
        // we return it because one of the nodes has been found.
        if (root.data == a || root.data == b) {
            return root;
        }

        // 🔍 Recurse for left and right subtrees.
        BinaryTreeNode<Integer> leftLCA = getLCAHelper(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCAHelper(root.right, a, b);

        // ✅ If both sides return a non-null node, this means
        // current root is the LCA (because one key was found in each subtree).
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // 🔁 If only one side is non-null, bubble up that side.
        // If both sides are null, this will return null.
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static BinaryTreeNode<Integer> getLCA_BST(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) {
            return null;
        }
        // this condition is not needed to be honest
        if (root.data == a || root.data == b) {
            return root;
        }
        // If both nodes are smaller, LCA must be in the left subtree
        if (a < root.data && b < root.data) {
            return getLCA_BST(root.left, a, b);
        }
        // If both nodes are greater, LCA must be in the right subtree
        else if (a > root.data && b > root.data) {
            return getLCA_BST(root.right, a, b);
        } else {
            // One node is on left, the other on right, or one is the root itself
            return root;
        }
    }
}
