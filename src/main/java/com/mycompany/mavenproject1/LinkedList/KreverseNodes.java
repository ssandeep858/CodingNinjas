/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.enhancedInsertValues;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;
import static com.mycompany.mavenproject1.LinkedList.SwapNodes.swapNodes;

/**
 *
 * @author ssingh
 */
public class KreverseNodes {

    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        //Your code goes here
        if (k <= 0 || head == null) {
            return head;
        }
        Node<Integer> temp = head;
        int nodeCount = 0;
        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }
        temp = head;
        if (k == nodeCount) {
            Node<Integer> prev = null, curr = temp, next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        } else {
            int count = 0;
            Node<Integer> prev = null, curr = temp, next = null;
            while (count != k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // Next isliye kyunki aage waale ya next waale reverse karega na ab voh
            head.next = kReverse(next, k);
            return prev;
        }

    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        //head = insertNode(head, 7, 0);
        print(head);
        System.out.println("");
        //head = deleteNodeEnhanced(head, 2);
        //incrementNodeValue(head);
        head = kReverse(head, 3);
        print(head);
    }

}
