/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

/**
 *
 * @author ssingh
 */
public class RemoveLeavesBinaryTree {

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }

        // left and right ko update krna bahot jarruri hai 
        // as agr null return kara left ya right subTree ne toh usko update krna hoga
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

}
