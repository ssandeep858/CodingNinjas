/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.Array.ListOrHashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author ssingh Input: cells = [0,1,0,1,1,0,0,1], n = 7 Output:
 * [0,0,1,1,0,0,0,0] Explanation: The following table summarizes the state of
 * the prison on each day: Day 0: [0, 1, 0, 1, 1, 0, 0, 1] Day 1: [0, 1, 1, 0,
 * 0, 0, 0, 0] Day 2: [0, 0, 0, 0, 1, 1, 1, 0] Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0] Day 5: [0, 1, 1, 1, 0, 1, 0, 0] Day 6: [0, 0,
 * 1, 0, 1, 1, 0, 0] Day 7: [0, 0, 1, 1, 0, 0, 0, 0] Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000 Output: [0,0,1,1,1,1,1,0]
 */
public class PrisonAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> hashSet = new HashSet<>();
        boolean isCycle = false;
        for (int i = 0; i < n; i++) {
            int[] nextDay = findNextDay(cells);
            if (hashSet.contains(Arrays.toString(nextDay))) {
                n %= hashSet.size();
                isCycle = true;
                break;
            } else {
                hashSet.add(Arrays.toString(nextDay));
            }
            cells = Arrays.copyOf(nextDay, nextDay.length);
        }
        if (isCycle) {
            for (int i = 0; i < n; i++) {
                cells = findNextDay(cells);
            }
        }
        return cells;
    }

    public static int[] findNextDay(int[] cells) {
        int temp[] = new int[cells.length];
        for (int j = 1; j < 7; j++) {
            if (cells[j - 1] == cells[j + 1]) {
                temp[j] = 1;
            } else {
                temp[j] = 0;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    }

}
