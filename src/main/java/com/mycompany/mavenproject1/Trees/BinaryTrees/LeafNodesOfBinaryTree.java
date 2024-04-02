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
public class LeafNodesOfBinaryTree {

    public static int leafNodesOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLeafs = leafNodesOfBinaryTree(root.left);
        int rightLeafs = leafNodesOfBinaryTree(root.right);
        return leftLeafs + rightLeafs;
    }
}
