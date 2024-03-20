/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

/**
 *
 * @author ssingh You are given the head of a singly linked-list. The list can
 * be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4] Output: [1,4,2,3] Example 2:
 *
 *
 * Input: head = [1,2,3,4,5] Output: [1,5,2,4,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104]. 1 <= Node.val
 * <= 1000
 */
public class reorderList {

    public static void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        // jab tak fast pointer last node pr na pahunch jae 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // ab slow wala pointer break karega list ko half mein 
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode firstHalf = head;

        // reverse karo second half wali list ko
        ListNode prev = null, curr = secondHalf, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        while (firstHalf != null && secondHalf != null) {
            ListNode t1 = firstHalf.next;
            ListNode t2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = t1;
            firstHalf = t1;
            secondHalf = t2;
        }

    }
}
