package com.mycompany.mavenproject1.Trees.BinaryTrees;

/*
 * Problem statement
Given a Binary tree, find the largest BST subtree. 
That is, you need to find the BST with maximum height in the given binary tree. 
You have to return the height of largest BST.

Note :
The binary tree will be consisting of only unique elements.
 */

public class LargestBst {

    // ✅ Subtree info container: holds data for each subtree
    static class BstInfo {
        int min; // Minimum value in this subtree
        int max; // Maximum value in this subtree
        int height; // Height of the largest BST in this subtree
        boolean isBST; // Whether this subtree is a valid BST

        public BstInfo(int min, int max, int height, boolean isBST) {
            this.min = min;
            this.max = max;
            this.height = height;
            this.isBST = isBST;
        }
    }

    // ✅ Main method: returns height of the largest BST subtree in the whole tree
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return helper(root).height;
    }

    // ✅ Helper function: computes BstInfo for subtree rooted at 'root'
    public static BstInfo helper(BinaryTreeNode<Integer> root) {
        // 🟢 Base case: An empty subtree is a valid BST with height 0
        // min is set to +infinity, max to -infinity to not interfere in comparisons
        if (root == null) {
            return new BstInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        // 🔍 Recurse for left and right children
        BstInfo lefttree = helper(root.left);
        BstInfo rightree = helper(root.right);

        // ✅ Check if the current subtree is a valid BST:
        // - Left and right must be BSTs
        // - Current node must be greater than left max and smaller than right min
        boolean isCurrentBST = lefttree.isBST && rightree.isBST
                && (lefttree.max < root.data)
                && (rightree.min > root.data);

        // 🟢 Update min and max for the current subtree
        int minVal = Math.min(root.data, Math.min(lefttree.min, rightree.min));

        // ⚠️ Your original code has a bug here: using Math.min for maxVal
        // It should be Math.max so the maximum value is correctly tracked.
        int maxVal = Math.max(root.data, Math.max(lefttree.max, rightree.max));

        // 🔢 Compute height:
        // - If current subtree is a BST, add 1 for current node
        // - Else, take the max height of valid BSTs in children
        int height = Math.max(lefttree.height, rightree.height);

        if (isCurrentBST) {
            return new BstInfo(minVal, maxVal, 1 + height, true);
        } else {
            return new BstInfo(minVal, maxVal, height, false);
        }
    }

}
