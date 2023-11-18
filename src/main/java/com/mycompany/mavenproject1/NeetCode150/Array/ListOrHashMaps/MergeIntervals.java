/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ssingh
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> response = new ArrayList<List<Integer>>();
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            // PRIMITIVE PR compareTo ya compare method nahi chalta 
//            // so either do comparison for -1,0 or 1
//            public int compare(int[] o1, int[] o2) {
//                int value1 = o1[0];
//                int value2 = o2[0];
//                return ((Integer)value1).compareTo((Integer)value2);
//            }
//        });
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] previousInterval = intervals[0];
        System.out.println(Arrays.deepToString(intervals));
        //[[1, 3], [2, 6], [8, 10], [15, 18]]
        for (int i = 1; i < intervals.length; i++) {
            if (previousInterval[1] >= intervals[i][0]) {
                previousInterval[1] = Math.max(previousInterval[1], intervals[i][1]);
            } else {
                res.add(previousInterval);
                previousInterval = intervals[i];
            }
        }
        res.add(previousInterval);
        // if res empty then will take space given in brackets
        return res.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{{1, 3}, {15, 18}, {8, 10}, {2, 6}});
        System.out.println(Arrays.deepToString(result));
    }

}
