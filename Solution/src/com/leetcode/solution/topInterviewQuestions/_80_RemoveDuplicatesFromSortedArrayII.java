package com.leetcode.solution.topInterviewQuestions;

public class _80_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3, 3, 3, 3, 4, 4};
        int k = removeDuplicates(nums);
        System.out.printf("Result: " + k + "\n");
        for (int i : nums) {
            System.out.printf(i + " ");
        }
    }

    // Compare index k-1 with index i
    // If different, replace k+1 which i
    // Because k will in range of [[k-1];[k+1]] => we will make sure that there only have maximum of 2 duplicate value
    public static int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }
}
