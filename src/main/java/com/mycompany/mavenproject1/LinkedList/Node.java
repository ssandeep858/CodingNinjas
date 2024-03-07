/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data){
        this.data=data;
        next=null;
    }
}
