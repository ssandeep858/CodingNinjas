/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.enhancedInsertValues;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;

/**
 *
 * @author ssingh
 */
public class EvenAfterOdd {

    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
        // Your code goes here
        Node<Integer> oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        Node<Integer> temp = head;
        while (temp!=null && temp.data != -1) {
            if (temp.data % 2 == 1) {
                // odd case
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            } else {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }
            temp = temp.next;
        }
        // 1_2_3_4_5_6_7_null
        // even ke 6 ke next mein abhi bhi 7 hoga so dono ko last mein khud se null
        // daalo taaki unwanted connection na rahe
        if (oddTail != null) {
            oddTail.next = null;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        if (oddHead != null) {
            oddTail.next = evenHead;
            return oddHead;
        } else {
            return evenHead;
        }
      
    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        //head = insertNode(head, 7, 0);
        print(head);
        Node<Integer> res = evenAfterOdd(head);
        System.out.println("");
        print(res);
    }
}
