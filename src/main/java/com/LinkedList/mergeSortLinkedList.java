/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;




/**
 *
 * @author ssingh
 */
public class mergeSortLinkedList {

    
    public static Node<Integer> mergeTwoSortedLists(Node<Integer> head1,Node<Integer> head2) {
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        
        Node<Integer> t1=head1,t2=head2;
        Node<Integer> head=null;
        Node<Integer> tail=null;
        
        if(t1.data<=t2.data){
            head=t1;
            tail=t1;
            t1=t1.next;
        }else{
            head=t2;
            tail=t2;
            t2=t2.next;
        }
        
        while(t1!=null && t2!=null){
            if(t1.data<=t2.data){
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }else{
                tail.next=t2;
                tail=t2;
                t2=t2.next;
            }
        }
        if(t1!=null){
            tail.next=t1;
        }
        if(t2!=null){
            tail.next=t2;
        }
        return head;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        //Your code goes here
        if(head==null || head.next==null){
            System.out.println(head.data);
            System.out.println("");
            return head;
        }
        Node<Integer> midPoint = findMidPoint(head);
        System.out.println("Mid point value is");
        
        InsertDeleteNode.print(midPoint);
        System.out.println("");
        Node<Integer> list1= head;
        Node<Integer> list2= midPoint.next;
        midPoint.next=null;
        System.out.println("first half of list");
        InsertDeleteNode.print(list1);
        System.out.println("");
        System.out.println("second half of list");
        InsertDeleteNode.print(list2);
        System.out.println("");
        list1=mergeSort(list1);
        list2=mergeSort(list2);
        Node<Integer> res=mergeTwoSortedLists(list1,list2);
        return res;
    }

    public static Node<Integer> findMidPoint(Node<Integer> head) {
        Node<Integer> slow=head,fast=head;    
        // 1 2 3 4 5 6 
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    
    public static void main(String[] args) {
        Node<Integer> mainList = InsertDeleteNode.enhancedInsertValues();
        mainList=mergeSort(mainList);
        System.out.println("printing final list");
        InsertDeleteNode.print(mainList);
        
    }
}
