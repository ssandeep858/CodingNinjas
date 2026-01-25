package com.mycompany.mavenproject1.LinkedList;

public class DetectCycleAndRemove {

    public static boolean detectAndRemoveCycle(Node<Integer> head) {
        // ek element aur empty linkedList mein cycle nahi ho sakti
        if (head == null || head.next == null) {
            return false;
        }
        Node<Integer> slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // no cycle detected
        if (!hasCycle) {
            return false;
        }

        /*
         * slow==fast case
         * 1 → 2 → 3 → 4 → 5
         * ↑ ↓
         * ← ← ← ← ← ← ← ← ←
         */
        // 1. head and start of cycle is at the same spot
        slow = head;
        if (slow == fast) {
            // keep pushing fast ahead until fast.next is not equal to slow or we can say
            // head
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return true;
        }

        /*
         * case where cycle exist at any randomspot
         * 1 → 2 → 3 → 4 → 5
         * ........↑...... ↓
         * ..........← ← ←..
         * 
         */
        // we know from detection the fast and slow is at 4
        // find prevnode where slow=fast. and noth moved 1 step
        // slow is reset at head and fast at 4
        Node<Integer> prev = null;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
        return true;
        // agr node hota to retrun head.

    }

}
