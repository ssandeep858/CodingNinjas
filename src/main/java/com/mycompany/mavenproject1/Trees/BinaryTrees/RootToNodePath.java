package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;

public class RootToNodePath {

    class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {

        if (root == null) {
            return null;
        }

        if (root.data == data) {
            ArrayList<Integer> rootFound = new ArrayList<>();
            rootFound.add(root.data);
            return rootFound;
        }

        ArrayList<Integer> leftOutput = getPath(root.left, data);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        }

        // if no path foun don either left or right
        return null;
    }

}
