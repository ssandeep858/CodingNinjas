package NeetCode150.TreesOrGraphs;

import java.util.TreeSet;

public class KEmpltySlots {

    /*
     * LeetCode 683 — K Empty Slots (Medium)
     *
     * Question:
     * You have N bulbs in a row numbered 1..N. Each day exactly one bulb turns ON.
     * bulbs[day] = position that turns ON on day (day+1).
     *
     * Return the earliest day such that there exist two ON bulbs with exactly K OFF
     * bulbs between them.
     * In other words, find ON positions p < q where (q - p - 1) == K, and every
     * bulb strictly between
     * p and q is OFF on that day.
     * If no such day exists, return -1.
     *
     * Key Idea:
     * OFF bulbs are implicit (most bulbs are OFF). The condition is about TWO ON
     * bulbs having a gap of K
     * OFF bulbs between them with NO other ON bulb inside the gap.
     *
     * Why TreeSet:
     * We need to keep ON positions sorted and quickly find the nearest ON neighbors
     * of a new ON bulb:
     * - lower(x): closest ON position strictly less than x
     * - higher(x): closest ON position strictly greater than x
     * TreeSet supports add/lower/higher in O(log N) time (balanced BST / Red-Black
     * tree).
     *
     * Why only check neighbors:
     * When position x turns ON, any valid pair involving x must be with its
     * immediate ON neighbor on the
     * left or right. If you choose a farther ON bulb, there is already an ON bulb
     * between them, so the
     * bulbs in between are NOT all OFF.
     *
     * Gap formula (why "-1"):
     * If left = 2 and pos = 6, the bulbs strictly between are {3,4,5} => 3 bulbs.
     * Count = pos - left - 1 = 6 - 2 - 1 = 3.
     *
     * Complexity:
     * For each day (N days):
     * - add to TreeSet: O(log N)
     * - lower/higher queries: O(log N)
     * Total time: O(N log N)
     * Space: O(N) for storing ON bulb positions in TreeSet
     */

    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> on = new TreeSet<>();

        for (int day = 0; day < bulbs.length; day++) {
            int pos = bulbs[day];

            // Turn ON this bulb position
            on.add(pos);

            // Check closest ON bulb to the left
            Integer left = on.lower(pos);
            if (left != null && pos - left - 1 == k) {
                return day + 1; // days are 1-based
            }

            // Check closest ON bulb to the right
            Integer right = on.higher(pos);
            if (right != null && right - pos - 1 == k) {
                return day + 1; // days are 1-based
            }
        }

        return -1;
    }
}
