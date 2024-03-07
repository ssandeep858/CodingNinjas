/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.RemoveDuplicates.removeDuplicates;

/**
 *
 * @author ssingh
 */
public class PrintReverse {

    public static void printReverse(Node<Integer> root) {
        //Your code goes here
        if (root == null || root.next == null) {
            System.out.println(root.data);
            return;
        }
        Node<Integer> temp = root.next;
        printReverse(temp);
        System.out.println(root.data);
    }

//    10 => 20 => 30 => null
//  100 => 110 => 120 => null    
    public static void printReverseIterative(Node<Integer> head) {
        //Your code goes here
        Node<Integer> current=null,previous=null,next=null;
        current=head;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head=previous;
        System.out.println("printing");
        InsertDeleteNode.print(head);
    }

    public static void main(String[] args) {
        Node<Integer> head = InsertDeleteNode.enhancedInsertValues();
        //head = removeDuplicates(head);
        //InsertDeleteNode.print(head);
        //System.out.println("printing after this");
        //printReverse(head);
        printReverseIterative(head);
    }

}
