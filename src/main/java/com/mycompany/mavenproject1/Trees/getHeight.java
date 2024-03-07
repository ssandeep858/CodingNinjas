/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * Problem statement Given a generic tree, find and return the height of given
 * tree. The height of a tree is defined as the longest distance from root node
 * to any of the leaf node. Assume the height of a tree with a single node is 1.
 *
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints: Time
 * Limit: 1 sec Sample Input 1: 10 3 20 30 40 2 40 50 0 0 0 0 Sample Output 1: 3
 */
public class getHeight {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    // print all the nodes at depth k
    public static void depthOfNode(TreeNode<Integer> root, int k) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
         */
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data + " ");
        }

        for (int i = 0; i < root.children.size(); i++) {
            depthOfNode(root.children.get(i), k - 1);
        }

    }

    public static int getHeight(TreeNode<Integer> root) {
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
         */
        if (root == null) {
            return 0;
        }
        int rootHeight = 1;
        int currentMax = 0;

        for (int i = 0; i < root.children.size(); i++) {
            currentMax = Math.max(currentMax, getHeight(root.children.get(i)));
        }
        return currentMax + rootHeight;

    }
}
