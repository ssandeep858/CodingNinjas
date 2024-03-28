/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh Problem statement Given a generic tree, count and return the
 * number of leaf nodes present in the given tree. A node is said to be a leaf
 * node if it's not having any child
 *
 *
 * Leaf nodes in the given tree are 40, 50, 30, 40. So the answer for this is 4.
 * Detailed explanation ( Input/output format, Notes, Images ) Sample Input 1 :
 * 10 3 20 30 40 2 40 50 0 0 0 0 Sample Output 1 : 4
 */
public class CountLeafNode {

        class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }
    public static int countLeafNodes(TreeNode<Integer> root) {

        // Write your code here
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;

    }

}
