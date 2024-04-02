/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

/**
 *
 * @author ssingh
 */
public class printNodesWithoutSibling {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data);

        } else if (root.left != null && root.right == null) {
            System.out.print(root.left.data);

        }
        printNodesWithoutSibling(root.right);
        printNodesWithoutSibling(root.left);
    }

}
