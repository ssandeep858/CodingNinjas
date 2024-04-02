/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh
 */
public class ReturnLargestNodeData {

    class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int returnLargestNodeData(TreeNode<Integer> root) {

        if (root == null) {
            return -1;
        }

        int leftLargest = returnLargestNodeData(root.left);
        int rightLargest = returnLargestNodeData(root.right);
        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }
}
