/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

import java.util.HashMap;

/**
 *
 * @author ssingh Construct a deep copy of the list. The deep copy should
 * consist of exactly n brand new nodes, where each new node has its value set
 * to the value of its corresponding original node. Both the next and random
 * pointer of the new nodes should point to new nodes in the copied list such
 * that the pointers in the original list and copied list represent the same
 * list state. None of the pointers in the new list should point to nodes in the
 * original list.
 *
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node. Your code will only be given the head of the original
 * linked list.
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

public class copyRandomList {

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> hashMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            hashMap.put(temp, copy);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copy = hashMap.get(temp);
            copy.next = hashMap.get(temp.next);
            copy.random = hashMap.get(temp.random);
            temp = temp.next;
        }
        return hashMap.get(head);

    }

}
