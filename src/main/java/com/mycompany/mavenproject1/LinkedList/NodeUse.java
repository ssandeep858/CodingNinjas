/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class NodeUse {

    public static void main(String[] args) {
        Node<Integer> n1=new Node<>(7);
        Node<Integer> n2=new Node<>(14);
        n1.next=n2;
        Node<Integer> n3=new Node<>(21);
        n2.next=n3;
        Node<Integer> n4=new Node<>(28);
        n3.next=n4;
        Node<Integer> head=n1;
        while(head != null){
            System.out.println(head.data);
            head=head.next;
        }
    }
    
}
