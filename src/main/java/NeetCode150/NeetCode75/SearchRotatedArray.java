package NeetCode150.NeetCode75;

public class SearchRotatedArray {

    public static Integer searchHelper(int[] nums, Integer target, int start, int end) {
        if (nums.length == 0 || end < start) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (nums[mid] <= target && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return searchHelper(nums, target, start, end);

    }

    public static Integer search(int[] nums, Integer target) {
        // Your code goes here
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
    }

}
