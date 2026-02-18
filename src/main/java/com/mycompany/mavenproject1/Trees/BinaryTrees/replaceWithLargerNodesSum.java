package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary search tree, you have to replace 
 * each node's data with the sum of all nodes which 
 * are greater or equal than it. You need to include the current node's data also.

That is, if in given BST there is a node with data 5,
you need to replace it with sum of its data (i.e. 5) 
and all nodes whose data is greater than or equal to 5.

Note: You don't need to return or print, just change the data of each node.

HINT : Since it’s a BST, the in-order traversal gives you nodes in sorted ascending order.

To handle “greater than or equal”, you need to visit nodes in descending order, i.e., reverse in-order traversal:
right → node → left

You keep a running sum as you traverse, adding the current node’s value and updating its data with that sum.
 */

public class replaceWithLargerNodesSum {
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        // ✅ Use an array to hold the running sum by reference (mutable across
        // recursion)
        int[] sum = new int[1]; // sum[0] starts at 0
        helper(root, sum);
    }

    public static void helper(BinaryTreeNode<Integer> root, int[] sum) {
        // 🟢 Base case: If node is null, do nothing
        if (root == null) {
            return;
        }

        // 🔍 Reverse in-order traversal: right → node → left
        // This ensures you visit larger values before smaller ones
        helper(root.right, sum);

        // ✅ Update the running sum and replace the current node's data
        sum[0] += root.data; // Add current node's data to sum
        root.data = sum[0]; // Replace current node's data with the updated sum

        // 🔁 Continue with the left subtree (smaller values)
        helper(root.left, sum);
    }
}
