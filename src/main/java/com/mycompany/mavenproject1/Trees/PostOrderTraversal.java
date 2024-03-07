/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh Given a generic tree, print the post-order traversal of given
 * tree.
 *
 * The post-order traversal is: visit child nodes first and then root
 * node.Sample Input 1: 10 3 20 30 40 2 400 50 0 0 0 0 Sample Output 1: 400 50
 * 20 30 40 10 Explanation For 10 , total 3 children are there : 20 30 40 For
 * 20, total 2 children are there : 400 50 So, the output will be 400 50 20 30
 * 40 10
 */
public class PostOrderTraversal {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    public static void printPostOrder(TreeNode<Integer> root) {
        /* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
         */
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static void printPreOrder(TreeNode<Integer> root) {
        /* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
         */
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }

    }
}
