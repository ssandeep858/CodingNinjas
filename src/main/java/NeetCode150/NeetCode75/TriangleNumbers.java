package NeetCode150.NeetCode75;

import java.util.Arrays;

public class TriangleNumbers {
    public static Integer triangleNumber(int[] heights) {
        // Your code goes here
        Arrays.sort(heights);
        // 4,6,9,11,15,18
        // a + b > c to check

        int count = 0;
        for (int i = heights.length - 1; i >= 0; i--) {

            int a = 0;
            int b = i - 1;
            while (a < b) {
                if (heights[a] + heights[b] > heights[i]) {
                    count += b - a;
                    b--;
                } else {
                    a++;
                }
            }
        }
        return count;
    }

}
