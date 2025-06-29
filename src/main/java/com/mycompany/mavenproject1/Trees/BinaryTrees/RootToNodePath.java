package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;


public class RootToNodePath {

    

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        
        if(root==null){
            return null;
        }

        if(root.data==data){
            return new ArrayList<>(root.data);
        }

        ArrayList<Integer> leftOutput=getPath(root.left, data)


    }

}
