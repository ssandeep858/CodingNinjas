/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

/**
 *
 * @author ssingh
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class isSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are identical
        if (p == null && q == null)
            return true;

        // If one is null and the other is not, not identical
        if (p == null || q == null)
            return false;

        // If values differ, not identical
        if (p.val != q.val)
            return false;

        // Both values same: check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
