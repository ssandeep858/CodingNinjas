package NeetCode150.TreesOrGraphs;

import java.util.*;

public class ScheduleCourses {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if (!graph.containsKey(prereq)) {
                graph.put(prereq, new ArrayList<>());
            }
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int c = 0; c < inDegree.length; c++) { // <-- c++ (not i++)
            if (inDegree[c] == 0) {
                q.add(c);
            }
        }

        int coursesTaken = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            coursesTaken++;

            if (graph.containsKey(curr)) {
                List<Integer> nextCourses = graph.get(curr);
                for (int i = 0; i < nextCourses.size(); i++) {
                    int next = nextCourses.get(i);
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }

        return coursesTaken == numCourses;
    }

    public static void main(String[] args) {
        int numCourses3 = 4;
        int[][] prereq3 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        System.out.println("Example 3: " + canFinish(numCourses3, prereq3));

        int numCourses2 = 2;
        int[][] prereq2 = {{0,1}, {1,0}};
        System.out.println("Example 2: " + canFinish(numCourses2, prereq2));
    }
}
