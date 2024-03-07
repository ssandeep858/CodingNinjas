/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.enhancedInsertValues;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;
import static com.mycompany.mavenproject1.LinkedList.KreverseNodes.kReverse;

/**
 *
 * @author ssingh
 */
public class BubbleSort {

    /*
        public static Node<Integer> bubbleSort(Node<Integer> head, int length) {
        for (int i = 0; i < length; i++) {
            Node<Integer> prev = null, curr = head;
            while(curr.next!=null){
                if(curr.data<curr.next.data){
                    prev=curr;
                    curr=curr.next;
                }else{
                    if(prev==null){
                        Node<Integer> frwd=curr.next;
                        head=head.next;
                        curr.next=frwd.next;
                        frwd.next=curr;
                        prev=frwd;
                    }else{
                        Node<Integer> frwd=curr.next;
                        curr.next=frwd.next;
                        frwd.next=curr;
                        prev.next=frwd;
                        prev=frwd;
                    }
                }
            }
            
        }
        return head;
    }
     */
    
    
    // problem hai current ke next change hota rehta hai and prev bhi so nextNode leke computation galat hogi 
    // as swap krne ke baad previous next and current sab mess up ho jaega. 
    // isliye better ye hai ki sirf current se khelo and ek prev 
    public static Node<Integer> bubbleSort(Node<Integer> head, int length) {
        for (int i = 0; i < length; i++) {
            Node<Integer> prev = null, curr = head;
            while (curr.next != null) {
                if (curr.data < curr.next.data) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    if (prev == null) {
                        Node<Integer> frwd = curr.next;
                        head = head.next;
                        curr.next = frwd.next;
                        frwd.next = curr;
                        prev = frwd;
                    } else {
                        Node<Integer> frwd = curr.next;
                        curr.next = frwd.next;
                        frwd.next = curr;
                        prev.next = frwd;
                        prev = frwd;
                    }
                }
            }

        }
        return head;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {
        //Your code goes here
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return bubbleSort(head, length);
    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        //head = insertNode(head, 7, 0);
        print(head);
        System.out.println("");
        //head = deleteNodeEnhanced(head, 2);
        //incrementNodeValue(head);
        head = bubbleSort(head);
        //print(head);
    }
}
