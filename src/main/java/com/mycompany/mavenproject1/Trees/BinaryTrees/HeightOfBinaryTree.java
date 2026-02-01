/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

/**
 *
 * @author ssingh
 */

public class HeightOfBinaryTree {

    public static int height(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return 0;
        }
        int h = 1;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return h + Math.max(leftH, rightH);
    }
}
