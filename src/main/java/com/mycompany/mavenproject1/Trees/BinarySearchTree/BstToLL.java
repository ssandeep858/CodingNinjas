package com.mycompany.mavenproject1.Trees.BinarySearchTree;

import java.util.LinkedList;

public class BstToLL {

    // Problem statement
    // Given a BST, convert it into a sorted linked list. You have to return the
    // head of LL.

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        LinkedListNode<Integer> listNode = null;
        LinkedListNode<Integer> head=listNode;
        constructLinkedListHelper(root, listNode);
        return head.next;
    }

    public static void constructLinkedListHelper(BinaryTreeNode<Integer> root,
            LinkedListNode<Integer> list) {

                if(root==null){
                    return;
                }
                constructLinkedListHelper(root.left, list);
                list.next=new LinkedListNode<Integer>(root.data);
                constructLinkedListHelper(root.right, list);
    }
}
