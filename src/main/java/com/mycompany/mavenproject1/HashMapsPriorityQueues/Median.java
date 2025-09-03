
package com.mycompany.mavenproject1.HashMapsPriorityQueues;

import java.util.PriorityQueue;

public class Median {

    public static void findMedian(int arr[]) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        if (arr.length == 0) {
            System.out.println("no median");
        }
        for (int i = 0; i < arr.length; i++) {

            // max empty se start krna hai and current <= max.peek then max else minHeap
            if (maxHeap.isEmpty() || arr[i] <= maxHeap.peek()) {
                maxHeap.add(arr[i]);
            } else {
                minHeap.add(arr[i]);
            }

            // balancing
            // maxHeap can have only 1 extra element and that is for odd case
            if (maxHeap.size() > minHeap.size() + 1) {
                // sabse bada element will go to min heap right side
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                // sabse chota element will go to maxheap left side
                maxHeap.add(minHeap.poll());
            }

            int median = 0;
            if (maxHeap.size() > minHeap.size()) {
                median = maxHeap.peek();
            } else {
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            }
            System.out.println("median is " + median);
        }

    }

}

/*
 * ================================================================
 * RUNNING MEDIAN PROBLEM
 * ================================================================
 * 
 * PROBLEM: Find median after each element is added to a stream
 * 
 * SOLUTION: Use two heaps to maintain the middle element(s)
 * 
 * VISUALIZATION:
 * ==============
 * 
 * Stream: [1, 2, 3, 4, 5, 6, 7]
 * 
 * MaxHeap (Left) | MinHeap (Right)
 * -------------- | ---------------
 * [3, 2, 1] | [4, 5, 6, 7]
 * ↑ | ↑
 * max = 3 | min = 4
 * |
 * MEDIAN = 3 or 4
 * (depending on which has more elements)
 * 
 * KEY INSIGHT:
 * The median is always one of:
 * 1. Top of maxHeap (if it has more elements)
 * 2. Top of minHeap (if it has more elements)
 * 3. Average of both tops (if equal elements)
 * 
 * ================================================================
 * HEAP INITIALIZATION
 * ================================================================
 * 
 * MAX HEAP (Left Side):
 * - Stores the SMALLER half of all numbers
 * - We need the MAXIMUM of this smaller half (hence max heap)
 * - In Java, we use reverseOrder() to create a max heap
 * - Example: [3, 2, 1] with max = 3 at the top
 * 
 * MIN HEAP (Right Side):
 * - Stores the LARGER half of all numbers
 * - We need the MINIMUM of this larger half (hence min heap)
 * - In Java, PriorityQueue is min heap by default
 * - Example: [4, 5, 6] with min = 4 at the top
 * 
 * ================================================================
 * STEP 1: DECIDE WHICH HEAP TO ADD THE NUMBER TO
 * ================================================================
 * 
 * DECISION LOGIC:
 * We need to maintain the invariant that:
 * ALL elements in maxHeap <= ALL elements in minHeap
 * 
 * CASES:
 * 1. First element (maxHeap empty): Add to maxHeap by default
 * 2. currentNumber <= maxHeap.peek(): Belongs to smaller half
 * 3. currentNumber > maxHeap.peek(): Belongs to larger half
 * 
 * WHY CHECK maxHeap.peek()?
 * - maxHeap.peek() is the largest of the smaller half
 * - If current number <= this, it belongs in smaller half
 * - Otherwise, it belongs in larger half
 * 
 * Add to MAX HEAP (smaller half) when:
 * - It's the first element, OR
 * - Current number is smaller than or equal to the max of smaller half
 * 
 * Add to MIN HEAP (larger half) when:
 * - Current number is larger than the max of smaller half
 * - This ensures it belongs in the larger half
 * 
 * ================================================================
 * STEP 2: REBALANCE THE HEAPS
 * ================================================================
 * 
 * WHY REBALANCE?
 * ==============
 * We need the heaps to be balanced so that:
 * 1. The median is always at the top of one or both heaps
 * 2. We can calculate median in O(1) time
 * 
 * BALANCE RULES:
 * ==============
 * 1. Size difference between heaps should be at most 1
 * 2. If total elements is odd, maxHeap should have 1 extra
 * (This is our convention - we could also choose minHeap)
 * 
 * REBALANCING CASES:
 * ==================
 * 
 * CASE 1: MaxHeap has TOO MANY elements
 * =======================================
 * This happens when maxHeap has 2 or more extra elements
 * 
 * Example:
 * Before: maxHeap = [5,3,2], minHeap = [8]
 * Size: 3 Size: 1
 * Difference: 3 - 1 = 2 (TOO MUCH!)
 * 
 * Solution: Move the largest from maxHeap to minHeap
 * 
 * After: maxHeap = [3,2], minHeap = [5,8]
 * Size: 2 Size: 2
 * Difference: 0 (BALANCED!)
 * 
 * CASE 2: MinHeap has MORE elements than MaxHeap
 * ================================================
 * We don't allow minHeap to have more elements
 * We want maxHeap to have equal or 1 more element
 * 
 * Example:
 * Before: maxHeap = [3], minHeap = [5,8]
 * Size: 1 Size: 2
 * minHeap has MORE (NOT ALLOWED!)
 * 
 * Solution: Move the smallest from minHeap to maxHeap
 * 
 * After: maxHeap = [5,3], minHeap = [8]
 * Size: 2 Size: 1
 * maxHeap has 1 more (GOOD!)
 * 
 * If neither condition is true, heaps are already balanced!
 * This happens when:
 * - Both heaps have equal size, OR
 * - maxHeap has exactly 1 more element than minHeap
 * 
 * ================================================================
 * STEP 3: CALCULATE AND PRINT MEDIAN
 * ================================================================
 * 
 * After rebalancing, we have two cases:
 * 
 * CASE A: EVEN total number of elements
 * =======================================
 * Both heaps have equal number of elements
 * 
 * Example:
 * maxHeap = [3,2] (max = 3)
 * minHeap = [5,8] (min = 5)
 * Total elements = 4 (even)
 * 
 * The two middle elements are 3 and 5
 * Median = (3 + 5) / 2 = 4
 * 
 * Note: Integer division automatically gives us integer part
 * 
 * CASE B: ODD total number of elements
 * =====================================
 * maxHeap has 1 more element than minHeap
 * (Due to our rebalancing logic)
 * 
 * Example:
 * maxHeap = [5,3,2] (max = 5)
 * minHeap = [8,9] (min = 8)
 * Total elements = 5 (odd)
 * 
 * The middle element is at the top of the larger heap
 * Median = 5
 * 
 * Why maxHeap.peek()?
 * Because we always ensure maxHeap has the extra element
 * 
 * ================================================================
 * TEST CASES
 * ================================================================
 * 
 * TEST CASE 1: [5, 3, 8, 2, 9, 1, 6]
 * ====================================
 * Expected flow:
 * Add 5: median = 5
 * Add 3: median = (3+5)/2 = 4
 * Add 8: median = 5
 * Add 2: median = (3+5)/2 = 4
 * Add 9: median = 5
 * Add 1: median = (3+5)/2 = 4
 * Add 6: median = 5
 * 
 * TEST CASE 2: [1, 2, 3, 4, 5]
 * =============================
 * Already sorted input
 * 
 * TEST CASE 3: [5, 4, 3, 2, 1]
 * =============================
 * Reverse sorted input
 * 
 * ================================================================
 * COMPLEXITY ANALYSIS
 * ================================================================
 * 
 * TIME COMPLEXITY:
 * ================
 * For each element (N total):
 * - Adding to heap: O(log k) where k is heap size ≤ N/2
 * - Rebalancing (at most 1 removal + 1 insertion): O(log N/2) = O(log N)
 * - Getting median: O(1) (just peek operation)
 * 
 * Total: N elements × O(log N) = O(N log N)
 * 
 * SPACE COMPLEXITY:
 * =================
 * - Two heaps storing all N elements total: O(N)
 * - No additional space needed
 * Total: O(N)
 * 
 * ================================================================
 * WHY THIS IS OPTIMAL
 * ================================================================
 * 
 * ALTERNATIVES AND THEIR PROBLEMS:
 * =================================
 * 
 * 1. Sort array each time: O(N² log N) - TOO SLOW!
 * 2. Maintain sorted list: O(N²) for insertions - SLOW!
 * 3. Single heap: Can't efficiently get median
 * 4. This approach: O(N log N) - OPTIMAL!
 * 
 * KEY ADVANTAGES:
 * ===============
 * - Always have median in O(1) time
 * - Handles streaming data (don't need all elements upfront)
 * - Can process infinite streams
 * - Maintains running median efficiently
 * 
 * ================================================================
 * COMPLETE WALKTHROUGH
 * ================================================================
 * 
 * Stream: [5, 3, 8, 2]
 * 
 * Add 5: maxHeap=[5], minHeap=[]
 * Median = 5
 * 
 * Add 3: 3 <= 5, add to maxHeap
 * maxHeap=[5,3], minHeap=[]
 * Rebalance: move 5 to minHeap
 * maxHeap=[3], minHeap=[5]
 * Median = (3+5)/2 = 4
 * 
 * Add 8: 8 > 3, add to minHeap
 * maxHeap=[3], minHeap=[5,8]
 * Rebalance: move 5 to maxHeap
 * maxHeap=[5,3], minHeap=[8]
 * Median = 5
 * 
 * Add 2: 2 <= 5, add to maxHeap
 * maxHeap=[5,3,2], minHeap=[8]
 * Rebalance: move 5 to minHeap
 * maxHeap=[3,2], minHeap=[5,8]
 * Median = (3+5)/2 = 4
 * 
 * Output: 5 4 5 4
 * 
 * ================================================================
 * DEBUG STATEMENTS
 * ================================================================
 * 
 * Uncomment these for debugging:
 * 
 * System.out.println("Added " + currentNumber + " to maxHeap");
 * System.out.println("Added " + currentNumber + " to minHeap");
 * System.out.println("Moved " + elementToMove + " from maxHeap to minHeap");
 * System.out.println("Moved " + elementToMove + " from minHeap to maxHeap");
 * 
 * System.out.println("\nAfter adding " + currentNumber + ":");
 * System.out.println("MaxHeap: " + maxHeap + " (size: " + maxHeap.size() +
 * ")");
 * System.out.println("MinHeap: " + minHeap + " (size: " + minHeap.size() +
 * ")");
 * System.out.println("Median: " + median);
 * 
 * ================================================================
 * IMPLEMENTATION NOTES
 * ================================================================
 * 
 * 1. PriorityQueue<Integer> is min-heap by default in Java
 * 2. For max-heap: new PriorityQueue<>(Collections.reverseOrder())
 * 3. peek() returns top element without removing (O(1))
 * 4. poll() removes and returns top element (O(log n))
 * 5. offer() adds element to heap (O(log n))
 * 6. size() returns number of elements (O(1))
 * 7. isEmpty() checks if heap is empty (O(1))
 * 
 * ================================================================
 * EDGE CASES HANDLED
 * ================================================================
 * 
 * 1. Empty array: Works correctly, prints nothing
 * 2. Single element: Returns that element as median
 * 3. Two elements: Returns their average (integer division)
 * 4. Duplicate values: Handled correctly
 * 5. All same values: Returns that value
 * 6. Sorted ascending: Works efficiently
 * 7. Sorted descending: Works efficiently
 * 8. Random order: Works as expected
 * 
 * ================================================================
 */