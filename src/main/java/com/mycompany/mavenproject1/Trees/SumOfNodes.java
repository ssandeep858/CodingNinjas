/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh
 */
public class SumOfNodes {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    public static int greatestOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        
        int max = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            int currentMax= sumOfAllNode(root.children.get(i));
            max=Math.max(max, currentMax);
        }
        return max;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            sum += sumOfAllNode(root.children.get(i));
        }
        return sum;
    }
}
