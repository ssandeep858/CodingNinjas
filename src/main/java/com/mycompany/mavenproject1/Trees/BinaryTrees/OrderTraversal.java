package com.mycompany.mavenproject1.Trees.BinaryTrees;

public class OrderTraversal {

    public static void preOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        return;
    }

    public static void postOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
        return;
    }

    public static void inOrder(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
        return;
    }

}
