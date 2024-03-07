/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

import static NeetCode150.LinkedList.mergeTwoLists.*;

/**
 *
 * @author ssingh
 */
public class reverseList {

    public static ListNode reverseList(ListNode head) {
        
        ListNode current=head,prev=null,next=null;
        
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head=inputList();
        ListNode res=reverseList(head);
        printNodes(res);
    }

}
