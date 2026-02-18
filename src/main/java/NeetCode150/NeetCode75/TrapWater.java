package NeetCode150.NeetCode75;

public class TrapWater {
    public static Integer trappingWater(int[] height) {
        // Your code goes here
        int[] leftMax = new int[height.length];
        int rightMax[] = new int[height.length];

        int tempMax = -1;
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = 0;
            } else {
                tempMax = Math.max(tempMax, height[i - 1]);
                leftMax[i] = tempMax;
            }
        }
        tempMax = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMax[i] = 0;
            } else {
                tempMax = Math.max(tempMax, height[i + 1]);
                rightMax[i] = tempMax;
            }
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(rightMax[i], leftMax[i]) - height[i];
            if (temp <= 0) {
                continue;
            } else {
                count += temp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[] { 3, 4, 1, 2, 2, 5, 1, 0, 2 }));
    }
}
