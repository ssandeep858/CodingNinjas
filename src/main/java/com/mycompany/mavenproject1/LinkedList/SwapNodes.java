/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.DleteEveryNNodes.skipMdeleteN;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.enhancedInsertValues;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;

/**
 *
 * @author ssingh
 */
public class SwapNodes {

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        // base case
        if (i == j) {
            return head;
        }
        Node<Integer> currentNode = head, currentPrev = null, firstNode = null, firstNodePrev = null, secondNode = null,
                secondNodePrev = null;
        int indexValue = 0;
        while (currentNode != null) {
            if (indexValue == i) {
                firstNodePrev = currentPrev;
                firstNode = currentNode;
            } else if (indexValue == j) {
                secondNodePrev = currentPrev;
                secondNode = currentNode;
            }
            currentPrev = currentNode;
            currentNode = currentNode.next;
            indexValue++;
        }

        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode;
        }
        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode;
        }

        // end ka store kkarne ke liye liya hai jimein null bhi hota hai
        Node<Integer> temp = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = temp;

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        // head = insertNode(head, 7, 0);
        print(head);
        System.out.println("");
        // head = deleteNodeEnhanced(head, 2);
        // incrementNodeValue(head);
        head = swapNodes(head, 2, 4);
        print(head);
    }

    public static Node<Integer> swapNodesRevised(Node<Integer> head, int i, int j) {
        if (i == j) {
            return head;
        }

        Node<Integer> curr = head, currPrev = null, firstNode = null, firstPrev = null, secNode = null, secPrev = null;
        int counter = 0;

        while (curr != null) {
            if (counter == i) {
                firstPrev = currPrev;
                firstNode = curr;
            } else if (counter == j) {
                secPrev = currPrev;
                secNode = curr;
            }
            currPrev = curr;
            curr = curr.next;
            counter++;
        }

        if (firstNode == null || secNode == null) {
            return head; // or throw new IllegalArgumentException("Index out of bounds");
        }

        // pre.Next sort karna hai
        // 10->20->30->40->50->null

        if (firstPrev != null) {
            firstPrev.next = secNode;
        } else {
            head = secNode;
        }

        // if case is swapNodes(head, 3, 0)
        // 10 → 20 → 30 → 40 → 50 → null
        if (secPrev != null) {
            secPrev.next = firstNode;
        } else {
            head = firstNode;
        }

        // jaise swappig me next pehle nikalte hai so do tail end/next part first
        Node<Integer> temp = secNode.next;
        secNode.next = firstNode.next;
        firstNode.next = temp;
        return head;
    }

}
