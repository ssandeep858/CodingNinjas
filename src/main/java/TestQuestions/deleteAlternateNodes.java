/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

/**
 *
 * @author ssingh
 *
 * Problem statement Given a Singly Linked List of integers, delete all the
 * alternate nodes in the list.
 *
 * Example: List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null Alternate nodes will
 * be: 20, 40, and 60.
 *
 * Hence after deleting, the list will be: Output: 10 -> 30 -> 50 -> null Note :
 * The head of the list will remain the same. Don't need to print or return
 * anything. Detailed explanation ( Input/output format, Notes, Images ) Sample
 * Input 1: 1 2 3 4 5 -1 Sample Output 1: 1 3 5 Explanation of Sample Input 1:
 * 2, 4 are alternate nodes so we need to delete them Sample Input 2: 10 20 30
 * 40 50 60 70 -1 Sample Output 2: 10 30 50 70
 */
public class deleteAlternateNodes {

    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        if (head == null || head.next == null) {
            return;
        }
        Node<Integer> current = head;
        Node<Integer> nextNode;
        while (current != null && current.next != null) {
            nextNode = current.next.next;
            current.next = nextNode;
            current = nextNode;
        }
    }

    public static void deleteAlternateNodes2(Node<Integer> head) {
        //Your code goes here
        if (head == null || head.next == null) {
            return;
        }

        //  1 3 4 
        head.next = head.next.next;
        deleteAlternateNodes(head.next);
    }

}

