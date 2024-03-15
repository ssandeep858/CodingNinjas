/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ssingh For a given a Binary Tree of type integer, print the complete
 * information of every node, when traversed in a level-order fashion.
 *
 * To print the information of a node with data D, you need to follow the exact
 * format :
 *
 * D:L:X,R:Y
 *
 * Where D is the data of a node present in the binary tree. X and Y are the
 * values of the left(L) and right(R) child of the node. Print -1 if the child
 * doesn't exist. For the above depicted Binary Tree, the level order travel
 * will be printed as followed:
 *
 * 1:L:2,R:3 2:L:4,R:-1 3:L:5,R:6 4:L:-1,R:7 5:L:-1,R:-1 6:L:-1,R:-1 7:L:-1,R:-1
 *
 * Note: There is no space in between while printing the information for each
 * node.
 *
 */
public class PrintLevelWise {

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        //Your code goes here
      
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> currentNode=queue.poll();
            if(currentNode==null){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                //System.out.println("");
            }
            else{
                System.out.print(currentNode.data+":");
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                    System.out.print("L:"+currentNode.left.data);
                }else{
                    System.out.print("L:-1");
                }
                System.out.print(",");
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                    System.out.print("R:"+currentNode.right.data);
                }
                else{
                    System.out.print("R:-1");
                }
                System.out.println("");
            }
        }
    }
}
