package src.com.leetcode.solution;

public class _189_RotateArray {

    /*
    *
    * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]

    * */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 2);
        System.out.print("Result: \n");
        for (int i : nums) {
            System.out.printf(i + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length - 1) {
                nums[(i + k) % nums.length] = temp[i];
            } else {
                nums[i + k] = temp[i];
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0 || n == k) {
            return;
        }

        int count = 0;
        int start = 0;
        int current = start;
        int prev = nums[start];

        while (count < n) {
            current = (current + k) % n;
            int temp = nums[current];
            nums[current] = prev;
            prev = temp;
            count++;

            if (current == start) {
                start++;
                current = start;
                prev = nums[start];
            }
        }
    }
}

