/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mavenproject1.LinkedList;
import java.util.*;
/**
 *
 * @author ssingh
 */

public class InsertList {
    
    public static void print(Node<Integer> head){
        Node<Integer> temp=head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    public static Node<Integer> insertValues(){
        Node<Integer> head=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        
        while(data!=-1){
            Node<Integer> newNode=new Node<>(data);
            if(head == null){
                head=newNode;
            }
            else{
                Node<Integer> temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
            data=sc.nextInt();
        }
        return head;
    }
     public static Node<Integer> enhancedInsertValues(){
        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        
        while(data!=-1){
            Node<Integer> newNode=new Node<>(data);
            if(head == null){
                head=newNode;
                tail=head;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
            data=sc.nextInt();
        }
        return head;
    }
   
    public static void main(String[] args) {
        //Node<Integer> head=insertValues();
        Node<Integer> head=enhancedInsertValues();
        print(head);
    }
    
}
