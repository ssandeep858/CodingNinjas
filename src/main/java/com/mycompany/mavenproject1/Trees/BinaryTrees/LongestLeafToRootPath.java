package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the longest path from leaf to root. 
 * Longest means, a path which contain maximum number of nodes from leaf to root.
 */

public class LongestLeafToRootPath {

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        // ✅ Base case: if the node is null, return an empty list.
        // This happens when you reach past a leaf node.
        if (root == null) {
            return new ArrayList<>();
        }

        // ✅ Recursively find longest path in the left subtree
        ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);

        // ✅ Recursively find longest path in the right subtree
        ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);

        // ✅ Compare lengths of the two paths.
        // Whichever path is longer, add the current node's data to it.
        if (leftPath.size() > rightPath.size()) {
            // Left path is longer: add current node and return it.
            leftPath.add(root.data);
            return leftPath;
        } else {
            // Right path is longer (or equal length): add current node and return it.
            rightPath.add(root.data);
            return rightPath;
        }
    }

}
