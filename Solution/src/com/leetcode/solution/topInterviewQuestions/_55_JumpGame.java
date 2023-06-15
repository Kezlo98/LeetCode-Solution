package com.leetcode.solution.topInterviewQuestions;

public class _55_JumpGame {

    /*
    *
    * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

        Return true if you can reach the last index, or false otherwise.



        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    * */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.printf("Can Jump ? " + canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maximumIndex = 0;
        for(int i = 0; i <= maximumIndex; i ++){
            maximumIndex=Math.max(maximumIndex,nums[i]+i);
            if(maximumIndex >= nums.length -1) return true;
        }
        return false;
    }
}
