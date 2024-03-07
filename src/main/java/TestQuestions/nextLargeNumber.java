/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;

class LinkedListNode<T> {

    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

/**
 *
 * @author ssingh Given a large number represented in the form of a linked list.
 * Write code to increment the number by 1 in-place(i.e. without using extra
 * space).
 *
 * Note: You don't need to print the elements, just update the elements and
 * return the head of updated LL. Input Constraints: 1 <= Length of Linked List
 * <=10^6. Detailed explanation ( Input/output format, Notes, Images ) Sample
 * Input 1 : 3 9 2 5 -1 Sample Output 1 : 3 9 2 6 Sample Input 2 : 9 9 9 -1
 * Sample Output 1 : 1 0 0 0
 */
public class nextLargeNumber {

    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        head = reverseList(head);
        print(head);
        System.out.println("");
        LinkedListNode<Integer> temp = head;
        int carry = (temp.data + 1) % 10 == 0 ? 1 : 0;

        // carry flag very important here
        boolean carryFlag = carry == 1 ? true : false;
        while (temp != null && carry == 1) {
            System.out.println("temp value before" + temp.data);
            carry = (temp.data + 1) % 10 == 0 ? 1 : 0;
            temp.data = (temp.data + 1) % 10;
            System.out.println("carry value" + carry);
            System.out.println("temp value after" + temp.data);
            temp = temp.next;
        }
        if (carry == 1) {
            head = reverseList(head);
            LinkedListNode<Integer> newNode = new LinkedListNode<>(1);
            newNode.next = head;
            head = newNode;
        } else {
            if (!carryFlag) {
                temp.data += 1;
            }
            head = reverseList(head);
        }

        print(head);
        return head;
    }
//3 4 9 8 3 7 0 5 1 1 8 3 2 8 4 7 0 3 3 9 1 9 1 2 1 3 2 3 1 2 6 8 3 3 4 4 3 0 6 5 1 8 8 0 8 4 0 5 5 9 9 9 9 7 6 7 5 0 8 1 7 2 9 4 7 5 9 0 8 2 0 3 3 4 6 0 5 9 8 5 1 1 9 7 7 1 2 5 2 2 0 0 9 7 8 2 7 1 5 6 -1
//3 4 9 8 3 7 0 5 1 1 8 3 2 8 4 7 0 3 3 9 1 9 1 2 1 3 2 3 1 2 6 8 3 3 4 4 3 0 6 5 1 8 8 0 8 4 0 5 5 9 9 9 9 7 6 7 5 0 8 1 7 2 9 4 7 5 9 0 8 2 0 3 3 4 6 0 5 9 8 5 1 1 9 7 7 1 2 5 2 2 0 0 9 7 8 2 7 1 5 7 

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(9);
        LinkedListNode<Integer> temp = head;
        temp.next = new LinkedListNode<>(9);
        temp = temp.next;
        temp.next = new LinkedListNode<>(4);
        temp = temp.next;
        temp.next = new LinkedListNode<>(9);
        temp = temp.next;

        LinkedListNode<Integer> output = nextLargeNumber(head);

    }
}
