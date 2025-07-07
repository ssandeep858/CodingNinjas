package com.mycompany.mavenproject1.Trees.BinarySearchTree;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

/*
 * Given a BST and an integer k. Find if the integer k is present in given BST
 * or not. You have to return true, if node with data k is present, return false
 * otherwise.
 * 
 * Note:
 * Assume that BST contains all unique elements.
 */

public class SearchInBST {

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if(root==null){
            return false;
        }
        if(root.data==k){
            return true;
        }

        if(k>root.data){
            return searchInBST(root.right, k);
        }else{
            return searchInBST(root.left, k);
        }
    }
}
