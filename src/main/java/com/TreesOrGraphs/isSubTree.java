/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreesOrGraphs;

/**
 *
 * @author ssingh
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class isSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));  
    }
        public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (subRoot != null && root != null && subRoot.val == root.val) {
            return (isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
