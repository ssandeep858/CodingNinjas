package com.mycompany.mavenproject1.DP;

public class MinCostPath {

    /*
     * Initializes the memoization table
     * Calls minCostPathHelper(input, 0, 0, memo) - starting from position (0, 0)
     * 
     * The recursive helper explores paths from (0, 0) to the destination (rows-1,
     * cols-1) by moving down, right, or diagonally. When it finally returns back to
     * the original call, it returns the value stored in memo[0][0].
     * So the node returned at the very end is memo[0][0], which contains the
     * minimum cost to reach from the top-left corner (0, 0) to the bottom-right
     * corner (rows-1, cols-1).
     */
    public static int minCostPath(int[][] input) {
        // Your code goes here
        int columns = input[0].length;
        int rows = input.length;
        int[][] memo = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                memo[i][j] = -1;
            }
        }
        return minCostPathHelper(input, 0, 0, memo);
    }

    public static int minCostPathHelper(int[][] input, int row, int col, int[][] memo) {
        // Your code goes here
        int cols = input[0].length;
        int rows = input.length;

        if (row >= rows || col >= cols) {
            return Integer.MAX_VALUE;
        }
        // BASE CASE: We're at destination
        // The cost from destination to destination is just the cell value
        // We haven't computed memo[m-1][n-1] yet - it's still null/-1
        if (row == rows - 1 && col == cols - 1) {
            return input[row][col];
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int down = minCostPathHelper(input, row + 1, col, memo);
        int right = minCostPathHelper(input, row, col + 1, memo);
        int diagonal = minCostPathHelper(input, row + 1, col + 1, memo);

        int minCost = input[row][col] + Math.min(down, Math.min(right, diagonal));

        memo[row][col] = minCost;

        return minCost;

    }
    // Check if we've already computed the minimum cost from this cell (start, end)
    // -1 means "not computed yet", any other value means we've already calculated
    // it
    // Return the previously computed value to avoid redundant calculations
    // This is the "memoization" part - remembering previous results

    // Recursively calculate the minimum cost for all three possible moves:

    // Move DOWN: go from current cell (start, end) to cell (start+1, end)
    // This returns the minimum cost from (start+1, end) to destination

    // Move RIGHT: go from current cell (start, end) to cell (start, end+1)
    // This returns the minimum cost from (start, end+1) to destination

    // Move DIAGONAL: go from current cell (start, end) to cell (start+1, end+1)
    // This returns the minimum cost from (start+1, end+1) to destination

    // Calculate total minimum cost from current cell to destination:
    // = (value of current cell) + (minimum of the three possible paths)
    // Math.min(right, diagonal) finds min between right and diagonal
    // Math.min(down, ...) then finds min among all three

    // Store this calculated result in memo table so we don't recalculate it
    // if we encounter this cell again in another path

    // Return the minimum cost from current cell (start, end) to destination
    public static void main(String[] args) {
        // Test Case 1
        int[][] input1 = {
                { 3, 4, 1, 2 },
                { 2, 1, 8, 9 },
                { 4, 7, 8, 1 }
        };
        System.out.println("Test 1: " + minCostPath(input1)); // Expected: 13

        // Test Case 2
        int[][] input2 = {
                { 10, 6, 9, 0 },
                { -23, 8, 9, 90 },
                { -200, 0, 89, 200 }
        };
        System.out.println("Test 2: " + minCostPath(input2)); // Expected: 76

        // Test Case 3
        int[][] input3 = {
                { 9, 6, 0, 12, 90, 1 },
                { 2, 7, 8, 5, 78, 6 },
                { 1, 6, 0, 5, 10, -4 },
                { 9, 6, 2, -10, 7, 4 },
                { 10, -2, 0, 5, 5, 7 }
        };
        System.out.println("Test 3: " + minCostPath(input3)); // Expected: 18
    }


    
}
