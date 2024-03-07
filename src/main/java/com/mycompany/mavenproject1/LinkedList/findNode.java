/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh You have been given a singly linked list of integers. Write a
 * function that returns the index/position of integer data denoted by 'N' (if
 * it exists). Return -1 otherwise. Sample Input 1 : 2 3 4 5 2 6 1 9 -1 5 10 20
 * 30 40 50 60 70 -1 6 Sample Output 1 : 2 -1
 *
 */
public class findNode {

    public static int findNode(Node<Integer> head, int n, int pos) {
        if(head==null){
            return -1;
        }
        if(head!=null){
            if(head.data==n){
                return pos;
            }
            else return findNode(head.next, n,pos+1);
        }
        return pos;
    }

    public static int findNode(Node<Integer> head, int n) {
        // Write your code here.
        return findNode(head, n, 0);
    }

    public static void main(String[] args) {
        Node<Integer> head = InsertDeleteNode.enhancedInsertValues();
        InsertDeleteNode.print(head);
        int pos = findNode(head, 10);
        System.out.println("");
        System.out.println(pos);

    }
}
