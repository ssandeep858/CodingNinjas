/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh * Problem: Maximum Sum Node in a Generic Tree
 *
 *         You are given a generic tree where each node can have multiple
 *         children.
 *         Each node contains an integer value.
 *
 *         For every node, define its sum as:
 *         node.data + sum of data of all its immediate children.
 *
 *         Your task is to find and return the node for which this sum is
 *         maximum.
 *
 *         Note:
 *         - Only direct children are considered (not grandchildren).
 *         - If multiple nodes have the same maximum sum, return any one of
 *         them.
 */
public class MaxSumNode {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    static class Pair {

        TreeNode<Integer> maxNode;
        int sum;

        Pair(TreeNode<Integer> maxNode, int sum) {
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    public static Pair helper(TreeNode<Integer> root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        Pair curr = new Pair(root, sum);

        for (int i = 0; i < root.children.size(); i++) {
            Pair child = helper(root.children.get(i));

            if (child.sum > curr.sum) {
                curr.maxNode = child.maxNode;
                curr.sum = child.sum;
            }
        }
        return curr;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        Pair res = helper(root);
        return res.maxNode;
    }

}
