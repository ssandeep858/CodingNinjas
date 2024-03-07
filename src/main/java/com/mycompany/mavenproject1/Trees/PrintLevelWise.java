/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ssingh Given a generic tree, print the input tree in level wise
 * order. That is, print the elements at same level in one line (separated by
 * space). Print different levels in different lines. Sample Input : 10 3 20 30
 * 40 2 40 50 0 0 0 0 Sample Output : 10 20 30 40 40 50
 *
 */
class TreeNode<T> {

    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}

public class PrintLevelWise {

    public static void printLevelWise(TreeNode<Integer> root) {
        /* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
         */
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode<Integer> currentRoot = queue.remove();
            if (currentRoot == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                System.out.println();
            } else {
                System.out.print(currentRoot.data + " ");
                int size = currentRoot.children.size();
                for (int i = 0; i < size; i++) {
                    queue.add(currentRoot.children.get(i));
                }
            }
        }
        // 2 3 4 
        return;
    }
}
