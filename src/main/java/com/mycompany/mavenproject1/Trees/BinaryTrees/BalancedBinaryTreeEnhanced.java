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
class BalancedTreeReturnClass {

    int height;
    boolean isBalanced;

    BalancedTreeReturnClass(int hieght, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }

}

public class BalancedBinaryTreeEnhanced {

// Har step pr height calculate ki jarrurat nahi hai. recursive call krte hi leaf pr aa jaega 
// and then har subsequent step pr previous step ka jawaab hoga aur har baar height calculate krke computation nahi karni padegi   
    
    
    // O(n) instead of nlogn best case or n2 if more than one thing is asked of the node 
    public static BalancedTreeReturnClass isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            int height = 0;
            boolean isBlanced = true;
            BalancedTreeReturnClass balancedTreeReturnClass = new BalancedTreeReturnClass(height, isBlanced);
            return balancedTreeReturnClass;
        }

        BalancedTreeReturnClass leftBalance = isBalanced(root.left);
        BalancedTreeReturnClass rightBalance = isBalanced(root.right);
        boolean overallBalanced = leftBalance.isBalanced && rightBalance.isBalanced;

        if (Math.abs(leftBalance.height - rightBalance.height) > 1 || !overallBalanced) {
            return new BalancedTreeReturnClass(1 + Math.max(leftBalance.height, rightBalance.height), false);
        }

        return new BalancedTreeReturnClass(1 + Math.max(leftBalance.height, rightBalance.height), overallBalanced);
    }

}
