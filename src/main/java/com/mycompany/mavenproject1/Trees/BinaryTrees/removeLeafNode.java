package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}
/*
 * Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes,
 * which don't have any children.
 * 
 * Note : Root will also be a leaf node if it doesn't have any child. You don't
 * need to print the tree, just remove all leaf nodes and return the updated
 * root.
 */

public class removeLeafNode {
    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {

        // ✅ Base case: If the root is null, nothing to remove
        if (root == null) {
            return null;
        }

        // ✅ If the current node is already a leaf (no children), remove it by returning
        // null
        if (root.children.size() == 0) {
            return null;
        }

        // ✅ Get the list of children for this node
        ArrayList<TreeNode<Integer>> children = root.children;

        // ✅ Important: Loop **backward** through the children
        // If you iterate forward and remove elements, the indices shift,
        // which can cause you to skip elements or get an IndexOutOfBounds error.
        for (int i = children.size() - 1; i >= 0; i--) {
            TreeNode<Integer> currentChild = children.get(i);

            // ✅ Recursively remove leaf nodes in the subtree of this child
            TreeNode<Integer> result = removeLeafNodes(currentChild);

            // ✅ If the child became a leaf (returns null), remove it from the list
            if (result == null) {
                children.remove(i);
            }

            /*
             * ✅ This block would check: if, after removing children,
             * the current root now has no children left,
             * then it should also be removed by returning null.
             * You have commented this out — so the root will stay,
             * even if it becomes a leaf after pruning all its children.
             *
             * Keeping this commented means your root will not be removed,
             * which may be fine for certain test cases but is not the general case.
             *
             * // ✅ If root has no children left, it’s now a leaf → remove it too
             * if (root.children.size() == 0) {
             * return null;
             * }
             */
        }

        // ✅ Return the current root node with updated children list
        return root;
    }

}
