/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import java.util.Scanner;

/**
 *
 * @author ssingh
 */
public class InsertDeleteNode {

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node<Integer> enhancedInsertValues() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the values please");
        int data = sc.nextInt();

        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static Node<Integer> insertNode(Node<Integer> head, int data, int pos) {
        Node<Integer> newNode = new Node<>(data);
        Node<Integer> temp = head;

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        int intialPos = 0;
        while (intialPos != pos - 1) {
            temp = temp.next;
            intialPos++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static Node<Integer> deleteNodeEnhanced(Node<Integer> head, int pos) {
        if (head == null) {
            return head;
        }
        if (pos == 0 && head.next != null) {
            return head.next;
        } else {
            head.next = deleteNode(head.next, pos - 1);
        }
        return head;
    }

    public static void incrementNodeValue(Node<Integer> head) {
        while (head != null) {
            head.data++;
            head = head.next;
        }
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        Node<Integer> temp = head;
        if (temp == null) {
            return head;
        }
        if (pos == 0) {
            head = head.next;
            return head;
        }
        int initialPos = 0;
        while (temp.next != null && initialPos != pos - 1) {
            temp = temp.next;
            initialPos++;
        }
        // pos i swy ahead of actual number of elemets
        if (temp.next != null && initialPos + 1 == pos) {
            temp.next = temp.next.next;
        }
        return head;
    }

    public static Node<Integer> removeDuplicateElements(Node<Integer> head) {
        if(head==null){
            return head;
        }
        if(head.next !=null){
            if(head.data!=head.next.data){
                head.next = removeDuplicateElements(head.next);
            }
            else {
                head=removeDuplicateElements(head.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        //head = insertNode(head, 7, 0);
        print(head);
        System.out.println("");
        //head = deleteNodeEnhanced(head, 2);
        //incrementNodeValue(head);
        head=removeDuplicateElements(head);
        print(head);
    }
}
