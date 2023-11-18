/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class mergeTwoSorteds {

    public static Node<Integer> mergeTwoSortedsRewrite(Node<Integer> head1, Node<Integer> head2) {
        //Your code goes here
        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> head = null, tail = null;

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            tail.next = t1;
        }

        if (t2 != null) {
            tail.next = t2;
        }
        return head;
    }

    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
        //Your code goes here
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;
        Node<Integer> resHead = null;
        Node<Integer> resTail = null;
        if (temp1.data <= temp2.data) {
            resHead = temp1;
            resTail = temp1;
            temp1 = temp1.next;
        } else {
            resHead = temp2;
            resTail = temp2;
            temp2 = temp2.next;
        }
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                resTail.next = temp1;
                resTail = temp1;
                temp1 = temp1.next;
            } else {
                resTail.next = temp2;
                resTail = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp2 != null) {
            resTail.next = temp2;
        }

        if (temp1 != null) {
            resTail.next = temp1;
        }
        return resHead;
    }

    public static void main(String[] args) {
        Node<Integer> head1 = InsertDeleteNode.enhancedInsertValues();
        InsertDeleteNode.print(head1);
        Node<Integer> head2 = InsertDeleteNode.enhancedInsertValues();
        InsertDeleteNode.print(head2);
        System.out.println("Output is");
        Node<Integer> res = mergeTwoSortedsRewrite(head1, head2);
        InsertDeleteNode.print(res);
    }
}
