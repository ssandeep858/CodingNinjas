/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ssingh Problem statement Given a generic tree, find and return the
 * node with second largest value in given tree. Return NULL if no node with
 * required value is present.
 *
 * Detailed explanation ( Input/output format, Notes, Images ) Sample Input 1 :
 * 10 3 20 30 40 2 40 50 0 0 0 0 Sample Output 1 : 40
 */
public class SecondLargest {

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        // Write your code here

        
        
        if (root == null) {
            return null;
        }
        TreeNode<Integer> firstLargest = root;
        TreeNode<Integer> secondLargest = null;
        // isko isliye liya hai kyunki agr second node null hia toh second
        // if ke check pr fail kr jaega code isiye second larget element leke rakho and usse check kro
        int secondLargestElement = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            for (int i = 0; i < curr.children.size(); i++) {
                queue.add(curr.children.get(i));
            }

            if (curr.data > secondLargestElement) {
                if (curr.data > firstLargest.data) {
                    secondLargest = firstLargest;
                    firstLargest = curr;
                    secondLargestElement = secondLargest.data;
                } else if (curr.data < firstLargest.data && curr.data > secondLargestElement) {
                    secondLargest = curr;
                    secondLargestElement = curr.data;
                }
            }

        }
        return secondLargest;
    }

}
