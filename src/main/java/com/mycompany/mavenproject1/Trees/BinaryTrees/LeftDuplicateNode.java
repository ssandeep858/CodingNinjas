package com.mycompany.mavenproject1.Trees.BinaryTrees;

public class LeftDuplicateNode {

    /*
     * For a given a Binary Tree of type integer, duplicate every node of the tree
     * and attach it to the left of itself.
     * 
     * The root will remain the same. So you just need to insert nodes in the given
     * Binary Tree.
     * 
     * Example:
     * alt txt
     * 
     * After making the changes to the above-depicted tree, the updated tree will
     * look like this.
     * alt txt
     * 
     * You can see that every node in the input tree has been duplicated and
     * inserted to the left of itself.
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints :
     * 1 <= N <= 10^5
     * Where N is the total number of nodes in the binary tree.
     * 
     * Time Limit: 1 sec
     * Sample Input 1:
     * 10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
     * Sample Output 1:
     * 10
     * 10 30
     * 20 30 60
     * 20 50 60
     * 40 50
     * 40
     * Sample Input 2:
     * 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
     * Sample Output 2:
     * 8
     * 8 10
     * 5 10
     * 5 6
     * 2 6 7
     * 2 7
     */


    // simple swapping.  
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        // Your code goes here

        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = newNode;
        newNode.left = temp;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }

    // 1
    // 2 3
    // 4 5 6
    // N=1
    // temp=1
    //

}
