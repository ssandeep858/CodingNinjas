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
public class MovieSchedule {

 public static int earliestFinishTime(int[] comedyRelease, int[] comedyDuration, int[] dramaRelease, int[] dramaDuration) {
        // Combine release times and durations for both categories
        int[] combinedRelease = new int[comedyRelease.length + dramaRelease.length];
        int[] combinedDuration = new int[comedyDuration.length + dramaDuration.length];

        System.arraycopy(comedyRelease, 0, combinedRelease, 0, comedyRelease.length);
        System.arraycopy(dramaRelease, 0, combinedRelease, comedyRelease.length, dramaRelease.length);

        System.arraycopy(comedyDuration, 0, combinedDuration, 0, comedyDuration.length);
        System.arraycopy(dramaDuration, 0, combinedDuration, comedyDuration.length, dramaDuration.length);

        // Create an array of movie events with their type, start time, and end time
        int n = combinedRelease.length;
        MovieEvent[] events = new MovieEvent[n];

        for (int i = 0; i < n; i++) {
            events[i] = new MovieEvent(i < comedyRelease.length ? "comedy" : "drama", combinedRelease[i],
                    combinedRelease[i] + combinedDuration[i]);
        }

        // Sort the movie events by end time in ascending order
        Arrays.sort(events);

        // Use greedy approach to find the earliest finish time
        int finishTime = 0;
        for (MovieEvent event : events) {
            if (event.startTime >= finishTime) {
                finishTime = event.endTime;
            }
        }

        return finishTime;
    }

    public static void main(String[] args) {
        // Example usage
        int[] comedyRelease = { 1, 4 };
        int[] comedyDuration = { 3, 2 };
        int[] dramaRelease = { 5, 2 };
        int[] dramaDuration = { 2, 2 };

        int result = earliestFinishTime(comedyRelease, comedyDuration, dramaRelease, dramaDuration);
        System.out.println("The earliest time to finish at least one movie from each category is: " + result);
    }

    // MovieEvent class to represent movie events
    static class MovieEvent implements Comparable<MovieEvent> {
        String type;
        int startTime;
        int endTime;

        MovieEvent(String type, int startTime, int endTime) {
            this.type = type;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MovieEvent other) {
            return Integer.compare(this.endTime, other.startTime);
        }
    }
}
