package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Problem statement
You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.

Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.

Example:
For a given input tree(refer to the image below):
1. Target Node: 5
2. K = 2
Starting from the target node 5, the nodes at distance K are 7 4 and 1.
 */

/*
 * Step-by-step Approach
✅ Step 1: Create a Map of Parent Pointers (Undirected Graph)
In a binary tree, you can go left and right, but there's no direct way to go back to the parent. So we build a map like:

Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap;
This lets us treat the tree like an undirected graph: for any node, you can go to its left, right, or parent.

✅ Step 2: Find the Target Node
You are given the value of the target node (say 5). You must search the tree to find the node object that has this value.

✅ Step 3: BFS Traversal from Target
Now perform a BFS starting at the target node using a Queue. At each level of BFS, we explore:

Left child

Right child

Parent (from parentMap)

Track visited nodes with a Set to avoid revisiting.

When level == K, the current queue has all nodes at distance K.

✅ Step 4: Print Node Values
Once you reach level K, all nodes in the queue are exactly K distance from the target node. Print their values.

 */

public class NodeAtDistanceK {

    // 3
    // 5 1
    // 6 2 0 8
    // 7 4
    /*
     * map
     * 5=3 1=3 6=5 2=5 0=1 8=1 7=2 4=2
     **********
     * queue= 7 4 1
     * visited = 5 6 2 3 7 4 1
     * while
     * 0
     * 1
     * 2
     * You first do a level-order traversal to build a parent map.
     * 
     * Then you do a BFS from the target node, treating the tree like an undirected
     * graph (child → parent, parent → child).
     * 
     * You track the level to find all nodes at distance K.
     */
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int targetData, int k) {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        BinaryTreeNode<Integer> targetNode = FindTargetAndBuildParentMap(root, targetData, parentMap);
        if (targetNode == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);
        int level = 0;

        /*
         * **5
         ** / \
         ***6 10
         * / \
         ** 2 3
         ***** \
         ****** 9
         * Target Node: 3
         * 
         * K = 1( distance from node )
         * Q 9 6
         * V 3 9 6
         * l= 1, s= 1 
         * 
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {

                // had for loop here which failed for some reason.
                // never do queue.size() here as when you poll the size will be dynamic and mess
                // up your output
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }
                return;
            }

            // never do queue.size() here as when you poll the size will be dynamic and
            // change and mess up your output
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> currentNode = queue.poll();

                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.add(currentNode.left);
                    visited.add(currentNode.left);
                }

                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.add(currentNode.right);
                    visited.add(currentNode.right);
                }

                BinaryTreeNode<Integer> parent = parentMap.get(currentNode);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }

            }
            level++;
        }
    }

    public static BinaryTreeNode<Integer> FindTargetAndBuildParentMap(BinaryTreeNode<Integer> root, int targetData,
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap) {
        if (root == null) {
            return null;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> targetNode = null;
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = queue.poll();
            if (currentNode.data == targetData) {
                targetNode = currentNode;
            }

            // left child exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
                parentMap.put(currentNode.left, currentNode);
            }

            // right hild not null
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                parentMap.put(currentNode.right, currentNode);
            }
        }
        return targetNode;
    }

}
