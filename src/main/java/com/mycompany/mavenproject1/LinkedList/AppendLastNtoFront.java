/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * You have been given a singly linked list of integers along with an integer
 * 'N'. Write a function to append the last 'N' nodes towards the front of the
 * singly linked list and returns the new head to the list. Hint: Identify how
 * many pointers you require and try traversing them to right places and connect
 * nodes accordingly also don't forget to disconnect what's required else it
 * could create cycles.
 *
 * @author ssingh Sample Input 1 : 1 2 3 4 5 -1 3
 *         2 => 10 20 30 40 50 60 -1 5
 *         Sample Output 1 : 3 4 5 1 2
 *         2 => 20 30 40 50 60 10
 */
public class AppendLastNtoFront {

    public static int returnLength(Node<Integer> head) {
        Node<Integer> temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> AppendLastNtoFront(Node<Integer> head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        // First, find the length to handle n >= length case
        Node<Integer> temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Normalize n
        n = n % length;
        if (n == 0)
            return head;

        // Use two pointers with gap of n
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now slow points to newTail, fast points to tail
        Node<Integer> newHead = slow.next;
        slow.next = null; // Break connection
        fast.next = head; // Connect tail to old head

        return newHead;
    }
}
