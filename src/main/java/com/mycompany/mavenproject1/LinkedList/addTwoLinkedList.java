package com.mycompany.mavenproject1.LinkedList;

import java.util.Stack;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class addTwoLinkedList {

    public static Node<Integer> addLists(Node<Integer> l1, Node<Integer> l2) {

        // 1 2 9
        // 2 0 1 2

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node<Integer> returnHead = null, tailNode = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int digit = carry;
            if (!s1.isEmpty()) {
                digit += s1.pop();
            }
            if (!s2.isEmpty()) {
                digit += s2.pop();
            }
            carry = digit / 10;
            digit = digit % 10;
            Node<Integer> newNode = new Node<Integer>(digit);

            if (returnHead == null) {
                returnHead = newNode;
                tailNode = returnHead;
            } else {
                tailNode.next = newNode;
                tailNode = newNode;
            }

        }
        // result is reverse right now

        return reverse(returnHead);

    }

    private static Node<Integer> reverse(Node<Integer> returnHead) {

        Node<Integer> prev = null, curr = returnHead, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public static void main(String[] args) {

        // List1: 1 -> 2 -> 9 (129)
        Node<Integer> l1 = new Node<>(1);
        l1.next = new Node<>(2);
        l1.next.next = new Node<>(9);

        // List2: 2 -> 0 -> 1 -> 2 (2012)
        Node<Integer> l2 = new Node<>(2);
        l2.next = new Node<>(0);
        l2.next.next = new Node<>(1);
        l2.next.next.next = new Node<>(9);

        Node<Integer> result = addLists(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }

    private static void printList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
