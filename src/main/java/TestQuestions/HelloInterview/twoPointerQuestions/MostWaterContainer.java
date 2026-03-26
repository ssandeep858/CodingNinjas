package TestQuestions.HelloInterview;

public class MostWaterContainer {

    /*
     * Given an array heights where each element represents the height of a vertical
     * line, pick two lines to form a container. Return the maximum area (amount of
     * water) the container can hold.
     * 
     * What is area? Width × height, where width is the distance between walls, and
     * height is the shorter wall (water overflows at the shorter wall).
     * heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
     * 21 # walls at indices 0 and 7 (both height 3): width=7, height=3, area=21
     * heights = [1, 2, 1]
     * 2 # walls at indices 0 and 2: width=2, height=min(1,1)=1, area=2
     */

    public static Integer max_area(int[] heights) {
        // Your code goes here
        int maxArea=Integer.MIN_VALUE;
        int left=0;
        int right=heights.length-1;

        while(left<right){
            int tempArea=Math.min(heights[left], heights[right])*(right-left);
            maxArea=Math.max(maxArea, tempArea);
            if(heights[right]>heights[left]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(max_area(new int[] { 3, 4, 1, 2, 2, 4, 1, 3, 2 }));
    }
}
