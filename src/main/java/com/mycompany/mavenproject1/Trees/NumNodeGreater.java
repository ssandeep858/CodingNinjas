/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh Problem statement Given a tree and an integer x, find and
 * return number of Nodes which are greater than x.
 *
 * Detailed explanation ( Input/output format, Notes, Images ) Sample Input 1 :
 * 35 10 3 20 30 40 2 40 50 0 0 0 0 Sample Output 1 : 3 Explanation Since x=35,
 * the elements which are greater than 35 are 40, 40, 50, so the output for this
 * is 3. Sample Input 2 : 10 10 3 20 30 40 2 40 50 0 0 0 0 Sample Output 2: 5
 * Explanation Since x=10, the elements which are greater than 10 are 20, 30,
 * 40, 40, 50, so the output for this is 5.
 */
public class NumNodeGreater {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {

        // Write your code here		
        if (root == null) {
            return 0;
        }
        int count = root.data > x ? 1 : 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }

        return count;
    }
}
