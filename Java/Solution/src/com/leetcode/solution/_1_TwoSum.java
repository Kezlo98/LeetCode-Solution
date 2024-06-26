package src.com.leetcode.solution;

import java.util.HashMap;

public class _1_TwoSum {
    /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
     */

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println("Result: ");
        int[] results = twoSum(nums, 6);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracking = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            tracking.putIfAbsent(nums[i], i);
            int opposite = target - nums[i];
            if (tracking.containsKey(opposite) && (tracking.get(opposite) != i)) {
                return new int[]{tracking.get(opposite), i};
            }
        }

        return null;
    }
}
