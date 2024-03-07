/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ssingh
 */
public class ReplaceNodeWithDepth {

    public static void replaceWithDepthValue(TreeNode<Integer> root) {

        // Write your code here
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.remove();
            if (curr == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                level++;
            } else {
                curr.data = level;
                for (int i = 0; i < curr.children.size(); i++) {
                    queue.add(curr.children.get(i));
                }

            }
        }
        return;
    }

}
