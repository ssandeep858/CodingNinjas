
package com.mycompany.mavenproject1.Trees.BinaryTrees;
public class printNodesWithoutSibling1 {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data);

        } else if (root.left != null && root.right == null) {
            System.out.print(root.left.data);

        }
        printNodesWithoutSibling(root.right);
        printNodesWithoutSibling(root.left);
    }

}
