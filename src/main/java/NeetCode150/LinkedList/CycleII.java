/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.LinkedList;

/**
 *
 * @author ssingh Given the head of a linked list, return the node where the
 * cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
 * a parameter.
 * Do not modify the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node. Example 2:

 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node. Example 3:

 * Input: head = [1], pos = -1 Output: no cycle Explanation: There is no cycle
 * in the linked list.
 */
public class CycleII {

    public static ListNode returnCycleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            // if no cycle return null
            return null;
        }

        ListNode cycle = returnCycleNode(head);
        if (cycle == null) {
            return null;
        }
        ListNode slow = head;
        while (slow != cycle) {
            slow = slow.next;
            cycle = cycle.next;
        }
        return cycle;
    }

}
