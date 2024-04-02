/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

import com.mycompany.mavenproject1.Trees.BinaryTrees.BinaryTreeNode;

/**
 *
 * @author ssingh
 */
public class BinaryTreePrintAtDepthK {

    public static void binaryTreePrintAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        binaryTreePrintAtDepthK(root.left, k--);
        binaryTreePrintAtDepthK(root.right, k--);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) {
            return;
        }
        root.data = depth;
        changeToDepthTree(root.left, depth + 1);
        changeToDepthTree(root.right, depth + 1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTree(root, 0);
    }
}
