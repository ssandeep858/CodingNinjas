package com.mycompany.mavenproject1.Trees.BinarySearchTree;

public class SortedArrayToSubTree {

    /*
     * Given a sorted integer array A of size n, which contains all unique elements.
     * You need to construct a balanced BST from this input array. Return the root
     * of constructed BST.
     * 
     * Note: If array size is even, take first mid as root.
     */
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        return SortedArrayToBSTHelper(arr, 0, n - 1);
    }

    private static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        //int mid = (end - start) / 2;
        //This gives the index relative to the start, not the absolute index in the array.
        int mid = start + (end - start) / 2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[mid]);
        root.left=SortedArrayToBSTHelper(arr, start, mid-1);
        root.right=SortedArrayToBSTHelper(arr, mid+1,end);
        return root;
    }

}
