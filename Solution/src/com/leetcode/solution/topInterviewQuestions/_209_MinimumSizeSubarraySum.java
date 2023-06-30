package com.leetcode.solution.topInterviewQuestions;

public class _209_MinimumSizeSubarraySum {

    /*
        Given an array of positive integers nums and a positive integer target, return the minimal length of a
        subarray
        whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



        Example 1:

        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1
        Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0
     */

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print("Result: " + minSubArrayLen(7,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int windowSlideRange = nums.length;
        int firstPointOfSlideWindow = 0;
        int tempSum = 0;

        for (int i = 0; i < nums.length; i ++){
            tempSum += nums[i];
            while (tempSum >= target){
                windowSlideRange = Math.min(i - firstPointOfSlideWindow + 1,windowSlideRange);
                tempSum -= nums[firstPointOfSlideWindow];
                firstPointOfSlideWindow++;
            }
        }
        return windowSlideRange == nums.length ? 0 : windowSlideRange;


    }
}
