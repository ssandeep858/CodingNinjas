/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh Print ith Node Send Feedback For a given a singly linked list
 * of integers and a position 'i', print the node data at the 'i-th' position.
 * Note : Assume that the Indexing for the singly linked list always starts from
 * 0.
 *
 * If the given position 'i', is greater than the length of the given singly
 * linked list, then don't print anything.
 */
public class PrintNthNode {

    public static void print(Node<Integer> head, int pos) {
        Node<Integer> temp = head;
        int index = 0;
        while (temp != null) {
            if (index == pos) {
                System.out.print(temp.data);
            }

            index++;
            temp = temp.next;
        }
    }

    public static void printIthNode(Node<Integer> head, int i) {

        print(head, i);
    }

}
