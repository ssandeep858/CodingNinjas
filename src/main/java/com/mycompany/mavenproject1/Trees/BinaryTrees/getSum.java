/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

/**
 *
 * @author ssingh
 *
 * Sample Input 1: 2 3 4 6 -1 -1 -1 -1 -1 Sample Output 1: 15 Explanation : The
 * binary tree formed using the input values: 2, 3, 4, 6, -1, -1, -1, -1, -1.
 * Hence the sum is 15.
 */
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

public class getSum {

    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here.
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        sum += getSum(root.left);
        sum += getSum(root.right);
        return sum;
    }

}
