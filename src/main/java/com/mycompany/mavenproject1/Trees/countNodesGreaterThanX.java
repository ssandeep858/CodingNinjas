/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

/**
 *
 * @author ssingh
 */
public class countNodesGreaterThanX {

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

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root==null){
            return 0;
        }
        
        int count=0;
        if(root.data>x){
            count++;
        }
        int leftCount=countNodesGreaterThanX(root.left, x);
        int rightCount=countNodesGreaterThanX(root.right, x);
        
        return count+leftCount+rightCount;
    }

}
