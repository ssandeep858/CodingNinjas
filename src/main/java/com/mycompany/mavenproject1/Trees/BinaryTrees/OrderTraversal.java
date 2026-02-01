package com.mycompany.mavenproject1.Trees.BinaryTrees;

public class OrderTraversal {

    // No return needed as function call is already returning void
    public static void preOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

}
