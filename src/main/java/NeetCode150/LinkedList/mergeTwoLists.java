/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

import java.util.Scanner;

/**
 *
 * @author ssingh
 */
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeTwoLists {

    public static ListNode inputList() {

        ListNode head = null;
        ListNode tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the values please");
        int data = sc.nextInt();

        while (data != -1) {
            ListNode newNode = new ListNode(data);
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

    public static void printNodes(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode head = null;
        ListNode tail = null;
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        if (t1.val <= t2.val) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }

        if (t1 == null) {
            tail.next = t2;
        }
        if (t2 == null) {
            tail.next = t1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1=inputList();
        ListNode head2=inputList();
        printNodes(head1);
        System.out.println("");
        printNodes(head2);
        System.out.println("");
        ListNode res=mergeTwoLists(head1, head2);
        printNodes(res);
        
    }

}
