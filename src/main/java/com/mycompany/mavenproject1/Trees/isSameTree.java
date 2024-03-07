/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

/**
 *
 * @author ssingh
 */
public class isSameTree {

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        // Write your code here
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            return checkIdentical(root1.children.get(i), root2.children.get(i));
        }
        return true;
    }

}
