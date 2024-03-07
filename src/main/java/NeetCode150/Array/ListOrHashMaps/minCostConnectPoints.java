/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author ssingh You are given an array points representing integer coordinates
 * of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
 * distance between them: |xi - xj| + |yi - yj|, where |val| denotes the
 * absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are
 * connected if there is exactly one simple path between any two points.
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]] Output: 20 We can connect
 * the points as shown above to get the minimum cost of 20. Notice that there is
 * a unique path between every pair of points.
 */
public class minCostConnectPoints {

    // MINIMUM SPANNING TREE
    // PRIM'S ALGORITHM
    public static int minCostConnectPoints(int[][] points) {
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashSet<Integer> visitedNodes = new HashSet<>();
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty() && visitedNodes.size() < points.length) {
            int[] curNode = pq.poll();
            if (visitedNodes.contains(curNode[1])) {
                continue;
            }
            cost += curNode[0];
            visitedNodes.add(curNode[1]);
            for (int i = 0; i < points.length; i++) {
                if (!visitedNodes.contains(i)) {
                    pq.add(new int[]{calculateCost(points[curNode[1]], points[i]), i});
                }
            }

        }
        return cost;
    }

    public static int calculateCost(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

}
