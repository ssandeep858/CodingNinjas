/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh Sample Input 1 : 1 1 2 3 4 5 -1 Sample Output 1 : 3 Sample
 * Input 2 : 2 -1 1 2 3 4 -1 Sample Output 2 : 2
 */
public class midPoint {

    //
    public static Node<Integer> midPoint(Node<Integer> head) {
        //Your code goes here

        if (head == null) {
            return head;
        }
        Node<Integer> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = null;
        return slow;

    }

    public static void main(String[] args) {
        Node<Integer> head = InsertDeleteNode.enhancedInsertValues();
        InsertDeleteNode.print(head);
        Node<Integer> mid = midPoint(head);
        InsertDeleteNode.print(mid);
    }
}
