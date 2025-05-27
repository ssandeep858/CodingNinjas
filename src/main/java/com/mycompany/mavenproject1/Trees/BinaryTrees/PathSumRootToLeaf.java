package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/*
For a given Binary Tree of type integer and a number K, 
print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.

Example:
 * If you see in the above-depicted picture of Binary Tree, 
 * we see that there are a total of two paths, 
 * starting from the root and ending at the leaves which sum up to a value of K = 13.

The paths are:
a. 2 3 4 4
b. 2 3 8

One thing to note here is, there is another path in the right sub-tree in reference to the root, 
which sums up to 13 but since it doesn't end at the leaf, we discard it.
The path is: 2 9 2(not a leaf)
 */
public class PathSumRootToLeaf {

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, List<Integer> path) {
        // Your code goes here
        if (root == null) {
            return;
        }
        k -= root.data;
        path.add(root.data);

        if (root.left == null && root.right == null) {
            if (k == 0) {
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i)+" ");
                }
                System.out.println();
            } else {
                path.remove(root.data);
                return;
            }
        }

        rootToLeafPathsSumToK(root.left, k, path);
        rootToLeafPathsSumToK(root.right, k, path);
        path.remove(root.data);
    }

    // SIMPLER WAY where i understood the string thing.
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String path) {
        // Your code goes here
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && k == root.data) {
            System.out.print(path + " " + root.data);
            System.out.println();
        }

        rootToLeafPathsSumToK(root.left, k - root.data, path + root.data + " ");
        rootToLeafPathsSumToK(root.right, k - root.data, path + root.data + " ");
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        // Your code goes here
        List<Integer> arrayList = new ArrayList<>();
        rootToLeafPathsSumToK(root, k, arrayList);
        String a = "";
        rootToLeafPathsSumToK(root, k, a);
    }

}
