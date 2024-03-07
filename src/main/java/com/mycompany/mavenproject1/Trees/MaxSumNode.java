/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees;

import java.util.ArrayList;

/**
 *
 * @author ssingh
 */
public class MaxSumNode {

    class TreeNode<T> {

        T data;
        ArrayList<TreeNode<T>> children;

        TreeNode(T data) {
            this.data = data;
            children = new ArrayList<TreeNode<T>>();
        }
    }

    static class Pair {

        TreeNode<Integer> maxNode;
        int sum;

        Pair(TreeNode<Integer> maxNode, int sum) {
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    public static Pair helper(TreeNode<Integer> root) {
        if(root==null){
            return new Pair(null, 0);
        }
        int sum=root.data;
        for(int i=0;i<root.children.size();i++){
           sum+=root.children.get(i).data;
        }
        Pair curr=new Pair(root, sum);
        
        for(int i=0;i<root.children.size();i++){
            Pair child=helper(root.children.get(i));
            
            if(child.sum>curr.sum){
                curr.maxNode=child.maxNode;
                curr.sum=child.sum;
            }
        }
        return curr;
    }
    

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        Pair res=helper(root);
        return res.maxNode;
    }

}
