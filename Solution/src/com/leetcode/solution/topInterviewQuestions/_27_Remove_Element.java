package com.leetcode.solution.topInterviewQuestions;

public class _27_Remove_Element {

    public static void main(String[] args) {
        int[] nums = {3,3};

        int k = removeElement(nums, 3);

        for (int i : nums){
            System.out.printf(i + " ");
        }
    }

    public static int removeElement(int[] nums, int val){
        // Counter for keeping track of elements other than val
        int count = 0;
        // Loop through all the elements of the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is not val
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
