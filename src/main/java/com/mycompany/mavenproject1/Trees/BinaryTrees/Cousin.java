package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

/*
 * Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the
 * two nodes are cousins of each other or not. Two nodes are said to be cousins
 * of each other if they are at same level of the Binary Tree and have different
 * parents.
 * 
 * Do it in O(n).
 */
    // ✅ Helper class to store parent and height (level) for each node
class NodeInfo {
        int height; // Level (depth) in the tree
        BinaryTreeNode<Integer> parent; // Parent node reference

        public NodeInfo(int height, BinaryTreeNode<Integer> parent) {
            this.height = height;
            this.parent = parent;
        }
    }

public class Cousin {



    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        if (root == null)
            return false;

        // ✅ Map to store: node value → NodeInfo(height, parent)
        HashMap<Integer, NodeInfo> parentMap = new HashMap<>();

        // ✅ Queue for BFS traversal
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        // Start with root: height = 0, parent = null
        queue.add(root);
        parentMap.put(root.data, new NodeInfo(0, null));

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = queue.poll();

            // Get current node's parent and height info
            NodeInfo nodeInfo = parentMap.get(currentNode.data);

            // 🔍 Process left child if it exists
            if (currentNode.left != null) {
                // Add left child to queue
                queue.add(currentNode.left);

                // Save left child info: parent = current node, height = current height + 1
                parentMap.put(
                        currentNode.left.data,
                        new NodeInfo(nodeInfo.height + 1, currentNode));
            }

            // 🔍 Process right child if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);

                parentMap.put(
                        currentNode.right.data,
                        new NodeInfo(nodeInfo.height + 1, currentNode));
            }
        }

        // ✅ After BFS, get NodeInfo for p and q
        NodeInfo pInfo = parentMap.get(p);
        NodeInfo qInfo = parentMap.get(q);

        // 🔍 Check if both exist and satisfy cousin conditions
        if (pInfo != null && qInfo != null) {
            // ✅ Cousins: same height but different parents
            return pInfo.height == qInfo.height && pInfo.parent != qInfo.parent;
        }

        return false; // One or both nodes not found
    }

}
