package com.leetcode.solution.topInterviewQuestions;

public class _26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = removeDuplicates(nums);
        System.out.print("Result: " + k + " \n");
        for (int i : nums){
            System.out.printf(i + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length <= 1 ){
            return length;
        }
        int k = 1;
        for (int i = 1; i< length; i ++){
            if(nums[k-1] < nums[i]){
                if(k != i) {
                    nums[k] = nums[k] + nums[i];
                    nums[i] = nums[k] - nums[i];
                    nums[k] = nums[k] - nums[i];
                }
                k++;
            }
        }

        return k;
    }
}
