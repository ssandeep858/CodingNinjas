package com.mycompany.mavenproject1.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Problem statement
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.

Note:

1. Assume the given binary tree contains all unique elements.
2. In a pair, print the smaller element first. Order of different pairs doesn't matter.
 */
public class PairSumBinaryTree {

    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        getList(root, list);

        Collections.sort(list);

        int i=0;
        int j=list.size()-1;

        while(i<j){
            int currentSum= list.get(i)+list.get(j);

            if(currentSum==sum){
                System.out.println(list.get(i)+" "+list.get(j));
                j--;
                i++;
            }
            else if(currentSum>sum){
                j--;
            }
            else{
                i++;
            }
        }
    }

    public static void getList(BinaryTreeNode<Integer> root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        getList(root.left, list);
        getList(root.right, list);
    }
}
