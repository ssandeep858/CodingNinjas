package com.mycompany.mavenproject1.Trees.BinaryTrees;

/*
 * Problem statement
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
2 9 3 6 10 5 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 
 */

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class buildTreeInPost {

    // POST 4 5 2 6 7 3 1
    // In 4 2 5 1 6 3 7
    // root = 1

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int[] inOrder, int inS, int inE, int pS,
            int pE) {
        // Your code goes here
        if ((inS > inE) || (pS > pE)) {
            return null;
        }
        int rootData = postOrder[pE];
        // index in inOrder
        int rootIndex = -1;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        for (int i = inS; i <= inE; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        System.out.println("root index is " + rootIndex);
        if (rootIndex == -1) {
            return null;
        }
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPostS = pS;
        // leftPostE-leftPostS=leftInE-leftInS
        int leftPostE = leftInE - leftInS + leftPostS;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        //
        int rightPostS = leftPostE + 1;
        int rightPostE = pE - 1;
        // -1 ver very important as last one is root

        root.left = buildTreeHelper(postOrder, inOrder, leftInS, leftInE, leftPostS, leftPostE);
        root.right = buildTreeHelper(postOrder, inOrder, rightInS, rightInE, rightPostS, rightPostE);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        // Your code goes here
        return buildTreeHelper(postOrder, inOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }
}
