/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

import static NeetCode150.LinkedList.mergeTwoLists.inputList;
import static NeetCode150.LinkedList.mergeTwoLists.printNodes;

/**
 *
 * @author ssingh Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5] Example 2:
 *
 * Input: head = [1], n = 1 Output: [] Example 3:
 *
 * Input: head = [1,2], n = 1 Output: [1]
 */
public class removeNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode slow = new ListNode(0, head), fast = head;
        // ek node peeche se chalengein
        ListNode dummy = slow;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n -= 1;
        }
        // 0 1 2 
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = inputList();
        ListNode res = removeNthFromEnd(head, 2);
        printNodes(res);
    }

}
