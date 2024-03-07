/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreesOrGraphs;

/**
 *
 * @author ssingh
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

        grid[i][j] = '0';  // markng this node as visited

        if (i + 1 < grid.length && j < grid[0].length && grid[i + 1][j] == '1') {
            DFS(grid, i + 1, j);
        }
        if (i - 1 >= 0 && j < grid[0].length && grid[i - 1][j] == '1') {
            DFS(grid, i - 1, j);
        }
        if (i < grid.length && j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            DFS(grid, i, j + 1);
        }
        if (i < grid.length && j - 1 >=0 && grid[i][j - 1] == '1') {
            DFS(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'}
        };
        System.out.println(numIslands(grid));
    }

}
