/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NeetCode150.TreesOrGraphs;

/**
 *
 * @author ssingh
 */
/*
 * 🏝️ Number of Islands (LeetCode 200)
 *
 * Problem:
 * Given a 2D grid of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * Definition of an Island:
 * - An island is a group of connected '1' cells.
 * - Connections are allowed only horizontally and vertically (4-directional).
 * - Diagonal connections do NOT count.
 * - The island is surrounded by water ('0') or grid boundaries.
 *
 * Approach (DFS / Flood Fill):
 * - Traverse each cell in the grid.
 * - When a '1' is found:
 * -> Increment island count.
 * -> Perform DFS to mark all connected land cells as visited (convert to '0').
 * - Continue scanning until entire grid is processed.
 *
 * Why mark visited as '0'?
 * - To avoid counting the same island multiple times.
 *
 * Time Complexity: O(m × n)
 * Each cell is visited at most once.
 *
 * Space Complexity: O(m × n) (worst-case recursion stack)
 */

public class NumOfIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void DFS(char[][] grid, int i, int j) {

        grid[i][j] = '0'; // markng this node as visited

        if (i + 1 < grid.length && j < grid[0].length && grid[i + 1][j] == '1') {
            DFS(grid, i + 1, j);
        }
        if (i - 1 >= 0 && j < grid[0].length && grid[i - 1][j] == '1') {
            DFS(grid, i - 1, j);
        }
        if (i < grid.length && j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            DFS(grid, i, j + 1);
        }
        if (i < grid.length && j - 1 >= 0 && grid[i][j - 1] == '1') {
            DFS(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '1' }
        };
        System.out.println(numIslands(grid));
    }

}
