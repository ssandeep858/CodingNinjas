/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class RemoveDuplicates {

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        //Your code goes here
        // 1 1 2 2 3 3 -1
        Node<Integer> temp = head;
        while (temp.next != null) {
            if (temp.data.equals(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static Node<Integer> removeDuplicateElements(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        if (head.next != null) {
            if (head.data != head.next.data) {
                head.next = removeDuplicateElements(head.next);
            } else {
                head = removeDuplicateElements(head.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = InsertDeleteNode.enhancedInsertValues();
        head = removeDuplicates(head);
        InsertDeleteNode.print(head);
    }
}
