/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh Problem statement Given a singly linked list of integers and
 * an integer n, find and return the index for the first occurrence of 'n' in
 * the linked list. -1 otherwise.
 *
 * Follow a recursive approach to solve this.
 *
 * Note : Assume that the Indexing for the linked list always starts from 0.
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= t <= 10^2 0 <= M <= 10^5 Where M is the size of the singly linked list.
 *
 * Time Limit: 1sec Sample Input 1 : 1 3 4 5 2 6 1 9 -1 100 Sample Output 1 : -1
 * Sample Input 2 : 2 10 20010 30 400 600 -1 20010 100 200 300 400 9000 -34 -1
 * -34
 */
public class FindNodeinLLRecursive {

    public static int findNodeRec(Node<Integer> head, int n) {
        // Your code goes here
        return findNodeRec(head, n, 0);
    }

    public static int findNodeRec(Node<Integer> head, int n, int indexValue) {
        // Your code goes here
        if (head == null) {
            return -1;
        }
        if (head.data == n) {
            return indexValue;
        }
        return findNodeRec(head.next, n, indexValue + 1);
    }
}
