/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;
import com.mycompany.mavenproject1.Trees.BinaryTrees.RootToNodePath.BinaryTreeNode;
/**
 *
 * @author ssingh
 */
public class BalancedBinaryTree {

    // Math.abs or MODULUS ( right height -left height ) <= 1 then it is balanced 
    // maan ke chalna hai ki balanced hai    
    
    // agr full binary tree hoga to T= T (n) join two array  + 2 * T(n/2) two small arrya sory 
    // best case nlogn and worst n^2
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // ab left wale ka balanacing check karengein and right wale ka 
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int findHeight(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int height =1; 
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);
        
        return 1+Math.max(leftHeight, rightHeight);
    }

}
