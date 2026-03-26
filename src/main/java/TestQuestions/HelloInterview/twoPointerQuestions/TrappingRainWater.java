package TestQuestions.HelloInterview;

public class TrappingRainWater {
    public static Integer trappingWater(int[] height) {
        // Your code goes here
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int tempMax = -1;

        // left to right iteration
        for (int i = 0; i < height.length; i++) {
            // max seen so far
            if (i == 0) {
                leftMax[i] = height[0];
            } else {
                tempMax = Math.max(tempMax, height[i - 1]);
                leftMax[i] = tempMax;
            }
        }
        tempMax = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMax[i] = height[i];
            } else {
                tempMax = Math.max(tempMax, height[i + 1]);
                rightMax[i] = tempMax;
            }
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (temp <= 0) {
                continue;
            } else {
                count += temp;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[] {3, 4, 1, 2, 2, 5, 1, 0, 2}));

    }
}
