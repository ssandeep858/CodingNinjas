/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.LinkedList;

import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.enhancedInsertValues;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.print;
import static com.mycompany.mavenproject1.LinkedList.InsertDeleteNode.removeDuplicateElements;

/**
 *
 * @author ssingh You have been given a singly linked list of integers along
 * with two integers, 'M,' and 'N.' Traverse the linked list such that you
 * retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until
 * the end of the linked list. Indexing starts from 1.
 *
 * To put it in other words, in the given linked list, you need to delete N
 * nodes after every M nodes.
 *
 * Note : No need to print the list, it has already been taken care. Only return
 * the new head to the list. You can return null in case where all nodes will be
 * deleted. Detailed explanation ( Input/output format, Notes, Images )
 * Constraints : 1 <= t <= 10^2 0 <= P <= 10^5 Where P is the size of the singly
 * linked list. 0 <= M <= 10^5 0 <= N <= 10^5  *
 * Time Limit: 1sec
 * Sample Input 1 :
 * 1
 * 1 2 3 4 5 6 7 8 -1
 * 2 2
 * Sample Output 1 :
 * 1 2 5 6
 * Sample Input 2 :
 * 2
 * 10 20 30 40 50 60 -1
 * 0 1
 * 1 2 3 4 5 6 7 8 -1
 * 2 3
 * Sample Output 2 :
 * 1 2 6 7
 * Explanation of Sample Input 2 :
 * For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.
 *
 * For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 ->
 * 2 -> 6 -> 7.
 */
public class DleteEveryNNodes {

    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        // Your code goes here
        Node<Integer> newListHead = null, newListTail = null;

        int startValue = 0;
        int nodesToDelete = N;
        while (head != null && head.data != -1) {
            if (startValue == M) {
                if (nodesToDelete == 0) {
                    startValue = 0;
                    nodesToDelete = N;
                    //head = head.next;
                    continue;
                } else {
                    head = head.next;
                    nodesToDelete--;
                }
            } else {
                if (newListHead == null) {
                    newListHead = head;
                    newListTail = head;
                } else {
                    newListTail.next = head;
                    newListTail = head;
                }
                startValue++;
                head = head.next;
            }
        }
        if (newListHead != null) {
            newListTail.next = null;
            return newListHead;
        } else {
            return newListHead;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = enhancedInsertValues();
        //head = insertNode(head, 7, 0);
        print(head);
        System.out.println("");
        //head = deleteNodeEnhanced(head, 2);
        //incrementNodeValue(head);
        head = skipMdeleteN(head, 2, 2);
        print(head);
    }
}
