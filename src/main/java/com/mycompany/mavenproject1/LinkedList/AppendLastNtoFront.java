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

    // 1 2 3 4 5
    // 3
    // 1 2 3 4 5 6 7
    // 5
    public static Node<Integer> AppendLastNtoFront(Node<Integer> head, int n) {
        // Your code goes here
        if (head == null || n == 0) {
            return head;
        }
        // 4 3
        Node<Integer> returnHead = null;
        Node<Integer> tail = null;
        Node<Integer> temp = head;
        int count = returnLength(head);
        // System.out.println(count);
        while (temp.next != null) {

            if (count == n + 1) {
                tail = temp;
                // System.out.println(tail.data);
            }
            if (count == n) {
                // System.out.println(temp.data);
                returnHead = temp;
            }
            temp = temp.next;
            count--;
        }
        temp.next = head;
        tail.next = null;
        return returnHead;
    }

    public static Node<Integer> AppendLastNtoFrontEnhanced(Node<Integer> head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // list khatam
                return head;
            }
            fast = fast.next;
        }
        // 10 20 30 40 50 60
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node<Integer> returnHead;
        returnHead = slow.next;
        slow.next = null;
        fast.next = head;
        return returnHead;

    }

}
