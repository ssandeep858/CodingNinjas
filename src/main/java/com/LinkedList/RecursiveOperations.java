/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class RecursiveOperations {

    public static void printRecursive(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printRecursive(head.next);

    }

    public static void printReverseR(Node<Integer> head) {
        if (head == null) {
            return;
        }
        printReverseR(head.next);
        System.out.print(head.data + " ");

    }

    public static Node<Integer> insertRecursive(Node<Integer> head, int element, int pos) {
        // 1 2 3 
        // 4 => 10 

        if (head == null) {
            return head;
        }

        if (pos == 0) {
            Node<Integer> newNode = new Node<>(element);
            Node<Integer> temp = head;
            newNode.next = head;
            return newNode;
        }
        head.next = insertRecursive(head.next, element, pos - 1);
        return head;
    }

    public static Node<Integer> deleteRecursive(Node<Integer> head, int element) {

        if (head == null) {
            return head;
        }
        if (head.data == element) {
            head = head.next;
            return head;
        }
        head.next = deleteRecursive(head.next, element);
        return head;
    }

    public static Node<Integer> reverseLL(Node<Integer> head,Node<Integer> prev, Node<Integer>next) {
        
        // 1 2 3 
        if(head==null){
            return prev;
        }        
        next=head.next;
        head.next=prev;
           
        return reverseLL(next, head, next);
        
    }

    public static void main(String[] args) {
        Node<Integer> mainList = InsertDeleteNode.enhancedInsertValues();
        //printReverseR(mainList);
        //mainList = insertRecursive(mainList, 7, 3);
        //InsertDeleteNode.print(mainList);
        //mainList = deleteRecursive(mainList, 4);
        mainList=reverseLL(mainList, null, null);
        InsertDeleteNode.print(mainList);
    }
}
