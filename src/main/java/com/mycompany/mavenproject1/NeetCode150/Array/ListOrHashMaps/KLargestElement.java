/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.PriorityQueue;

/**
 *
 * @author ssingh Example 1:
 *
 * Input ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]],
 * [3], [5], [10], [9], [4]] Output [null, 4, 5, 5, 8, 8]
 *
 * Explanation KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4 kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5 kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 */
public class KLargestElement {

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    int nth;

    public KLargestElement(int k, int[] nums) {
        nth = k;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //System.out.println(pq);
    }

    public int add(int val) {
        pq.add(val);

        //System.out.println(pq);
        if (pq.size() > nth) {
            pq.poll();
            //System.out.println(pq);
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KLargestElement kthLargest = new KLargestElement(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.pq);
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

}
