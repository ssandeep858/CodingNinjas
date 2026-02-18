package com.mycompany.mavenproject1.Trees.BinarySearchTree;

public class ELementsInRange {

    /*
     * Given a Binary Search Tree and two integers k1 and k2, find and print the
     * elements which are in range k1 and k2 (both inclusive).
     * 
     * Print the elements in increasing order.
     * Sample Input 1:
     * 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
     * 6 10
     * Sample Output 1:
     * 6 7 8 10
     */
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null)
            return;

        if (root.data < k1) {
            // everything on left is even smaller → skip left
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            // everything on right is even larger → skip right
            elementsInRangeK1K2(root.left, k1, k2);
        } else {
            // in range → inorder to print in increasing order
            elementsInRangeK1K2(root.left, k1, k2);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right, k1, k2);
        }
    }

}
