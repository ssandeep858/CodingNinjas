/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

import java.util.HashSet;

/**
 *
 * @author ssingh public static boolean hasCycle(Node head) {
 *
 * Node slow = head, fast = head;
 *
 * while (fast != null && fast.next != null) { slow=slow.next;
 * fast=fast.next.next;
 *
 * if(slow==fast){ return true; } }
 *
 * return false; }
 */
class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Cycle {

    public static boolean hasCycle(Node head) {

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycleE(Node head) {

        Node temp = head;

        HashSet<Node> hash = new HashSet<>();
        while (temp != null && temp.next != null) {
            if (hash.contains(temp)) {
                return true;
            } else {
                hash.add(temp);
            }
            temp = temp.next;
        }

        return false;
    }

}
