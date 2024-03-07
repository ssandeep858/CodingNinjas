/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh Given an array of points where points[i] = [xi, yi] represents
 * a point on the X-Y plane and an integer k, return the k closest points to the
 * origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in). Input: points = [[3,3],[5,-1],[-2,4]],
 * k = 2 Output: [[3,3],[-2,4]] Explanation: The answer [[-2,4],[3,3]] would
 * also be accepted.
 */
public class kClosest {

    // nlogn
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer ed1 = (o1[0] * o1[0]) + (o1[1] * o1[1]);
                Integer ed2 = (o2[0] * o2[0]) + (o2[1] * o2[1]);
                return ed1.compareTo(ed2);
            }

        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(points[i]);
        }
        return res.toArray(new int[0][]);
    }

    //Bottom-up heapify has a time complexity of O(n), 
    //while top-down heapify has a time complexity of O(log n)
    public static int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = kClosest1(new int[][]{{1, 3}, {-2, 2}}, 1);
        System.out.println(Arrays.deepToString(res));
    }

}
