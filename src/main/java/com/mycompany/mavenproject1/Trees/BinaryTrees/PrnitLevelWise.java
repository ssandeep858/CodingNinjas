package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem statement
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.


For the above-depicted tree, when printed in a level order fashion, the output would look like:

10
20 30 
40 50 60
Where each new line denotes the level in the tree.
 */


// TRY USING TEST CASE WILL LOOK VERY EASY 
// 1 n 2 3 n
public class PrnitLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        // n
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = queue.peek();
            System.out.print(queue.poll().data + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if (queue.peek() == null) {
                queue.poll();
                System.out.println();
                // MAIN CONDITION HERE 
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

        }
    }

}