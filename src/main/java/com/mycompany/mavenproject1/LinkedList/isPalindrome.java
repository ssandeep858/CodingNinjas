/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

/**
 *
 * @author ssingh
 */
public class isPalindrome {

    public static boolean isPalindrome(Node<Integer> head) {
        //Your code goes here
        
        // finding the mid
        Node<Integer> slow=head,fast=head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("Mid value is "+ slow.data);
        
        
        Node<Integer> current=slow, prev=null,next=null;
        Node<Integer> reverseHead;

        // 1 2 3 4 5
        //n= 4 5
        // 3 -> null prev
        // prev =curr prev = 3
        // cur= next
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        reverseHead=prev;
        System.out.println("reverse is ");
        InsertDeleteNode.print(reverseHead);
        System.out.println("correct is ");
        InsertDeleteNode.print(head);
        while(head!=null && reverseHead !=null){
            if(!head.data.equals(reverseHead.data)){
                return false;
            }
            reverseHead=reverseHead.next;
            head=head.next;
        }
        
        
        
        //System.out.println("fast value is "+ fast.data);
        return true;
    }
    
    public static void main(String[] args) {
        Node<Integer> head = InsertDeleteNode.enhancedInsertValues();
        System.out.println(isPalindrome(head));
    }

}
