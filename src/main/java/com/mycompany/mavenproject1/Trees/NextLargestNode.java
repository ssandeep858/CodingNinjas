/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh Find and return the node whose value is the smallest number
 *         that is STRICTLY greater than n.
 *         min( all node values that are > n )
 * 
 */
public class NextLargestNode {
    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        // Write your code here
        if (root == null) {
            return null;
        }
        TreeNode<Integer> ans = null;
        if (root.data > n) {
            ans = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> res = findNextLargerNode(root.children.get(i), n);
            if (res != null) {
                if (ans == null || res.data < ans.data) {
                    ans = res;
                }
            }
        }
        return ans;

    }

}
