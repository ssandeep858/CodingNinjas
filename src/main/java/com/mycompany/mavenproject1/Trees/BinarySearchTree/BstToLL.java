package com.mycompany.mavenproject1.Trees.BinarySearchTree;

import java.util.LinkedList;

import stacks.checkRedundantBrackets;

public class BstToLL {

    // Problem statement
    // Given a BST, convert it into a sorted linked list. You have to return the
    // head of LL.
    /*
     * ✅ Let's Break it Down Step-by-Step (With Example):
     * Imagine this BST:
     * 
     * markdown
     * Copy
     * Edit
     * 2
     * / \
     * 1 3
     * In-order traversal is: 1 → 2 → 3, so the linked list should be:
     * 1 → 2 → 3
     * 
     * 🧠 What Does Each Recursive Call Do?
     * We are recursing right → root → left, and building the list from the back.
     * 
     * Step-by-Step Execution:
     * 🧩 1. Start with root = 2, headSoFar = null
     * java
     * Copy
     * Edit
     * headSoFar = helper(3, null); // Go right first
     * 🧩 2. Inside helper(3, null):
     * java
     * Copy
     * Edit
     * headSoFar = helper(null, null); // 3's right is null → returns null
     * current = new LinkedListNode(3);
     * current.next = null
     * return helper(null, current); // 3's left is null → returns current
     * ✅ Now the list is: 3
     * 
     * 🧩 3. Back in helper(2, ?), headSoFar = 3
     * java
     * Copy
     * Edit
     * current = new LinkedListNode(2);
     * current.next = 3
     * return helper(1, current);
     * ✅ Now the list is: 2 → 3
     * 
     * 🧩 4. Inside helper(1, 2):
     * java
     * Copy
     * Edit
     * headSoFar = helper(null, 2); // 1's right
     * current = new LinkedListNode(1)
     * current.next = 2
     * return helper(null, 1); // 1's left
     * ✅ Final linked list: 1 → 2 → 3
     * 
     * 🔄 What does return helper(root.left, current) mean?
     * We're telling recursion:
     * “Hey, I’ve just added the current node (root.data) in front of the list so
     * far. Now, please process the left subtree and attach it before the current
     * node.”
     * 
     * So it:
     * 
     * Builds right subtree first (→)
     * 
     * Then creates current
     * 
     * Then attaches left subtree before current (←)
     * 
     * In short:
     * You are building the linked list in reverse, one node at a time from right to
     * left.
     * 
     * ✅ Why this works well:
     * You don’t need a tail or tracking
     * 
     * You always insert at the front, and keep returning the new head
     * 
     * Visual Recap:
     * Step Action List So Far
     * 1 Visit 3 3
     * 2 Add 2 before 3 2 → 3
     * 3 Add 1 before 2 1 → 2 → 3
     * 
     * Let me know if you want a diagram or want this version written using in-order
     * Left → Root → Right instead (we can also do it that way).
     */

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    // 2 types of solution
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return constructLinkedListHelper(root, null);
    }

    public static LinkedListNode<Integer> constructLinkedListHelper(BinaryTreeNode<Integer> root,
            LinkedListNode<Integer> headSoFar) {
        if (root == null) {
            return headSoFar;
        }

        headSoFar = constructLinkedListHelper(root.right, headSoFar);

        LinkedListNode<Integer> current = new LinkedListNode<Integer>(root.data);

        current.next = headSoFar;

        return constructLinkedListHelper(root.left, current);
    }

    private static LinkedListNode<Integer> prev = null;
    private static LinkedListNode<Integer> head = null;

    public static LinkedListNode<Integer> constructLinkedList2(BinaryTreeNode<Integer> root) {
        head = null;
        prev = null;
        inOrder(root);
        return head;
    }

    private static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        LinkedListNode<Integer> current = new LinkedListNode<Integer>(root.data);
        if (prev == null) {
            head = current;
        } else {
            prev.next = current;
        }
        prev = current;
        inOrder(root.right);

    }
}
