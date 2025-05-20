package com.mycompany.mavenproject1.Trees.BinaryTrees;

/*
 * For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note: Assume that the Binary Tree contains only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 
 */
public class buildTreeInPre {
    // preOrder 1 2 4 5 3 6 7
    // inOrder 4 2 5 1 6 3 7
    // root = 1

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int preS, int preE, int inS,
            int inE) {
        // Your code goes here
        if ((inS > inE) || (preS > preE)) {
            return null;
        }

        int rootData = preOrder[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndex = -1;
        for (int i = inS; i < inOrder.length; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            return null;
        }

        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPreS = preS + 1;
        // leftPreE-leftPreS = leftInE-leftInS
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;
        root.left = buildTreeHelper(preOrder, inOrder, leftPreS, leftPreE, leftInS, leftInE);
        root.right = buildTreeHelper(preOrder, inOrder, rightPreS, rightPreE, rightInS, rightInE);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        // Your code goes here
        return buildTreeHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

}
