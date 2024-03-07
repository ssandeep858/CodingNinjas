/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestQuestions;

import java.util.Arrays;

/**
 *
 * @author ssingh
 */
public class Amazon2 {


    public static int earliestFinishTime(int[] comedyRelease, int[] comedyDuration, int[] dramaRelease, int[] dramaDuration) {
        int n = comedyRelease.length;

        // Create an array to store all possible movie combinations
        int[][] combinedMovies = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            combinedMovies[i] = new int[]{comedyRelease[i], comedyDuration[i]};
            combinedMovies[i + n] = new int[]{dramaRelease[i], dramaDuration[i]};
        }

        // Sort the combined movies based on their finish times
        Arrays.sort(combinedMovies, (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));

        int currentTime = 0;
        int totalWatchingTime = 0;

        // Iterate over the sorted movies to find the earliest finish time
        for (int i = 0; i < 2 * n; i++) {
            currentTime = Math.max(currentTime, combinedMovies[i][0]);
            totalWatchingTime = Math.max(totalWatchingTime, currentTime + combinedMovies[i][1] - combinedMovies[i][0]);
            currentTime += combinedMovies[i][1];
        }

        return totalWatchingTime + currentTime;
    }

    public static void main(String[] args) {
        int[] comedyRelease = {1, 4};
        int[] comedyDuration = {3, 2};
        int[] dramaRelease = {5, 2};
        int[] dramaDuration = {2, 2};

        int result = earliestFinishTime(comedyRelease, comedyDuration, dramaRelease, dramaDuration);
        System.out.println("The earliest time to finish watching one movie from each category is: " + result);
    }
}


