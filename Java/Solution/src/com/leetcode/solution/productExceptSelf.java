package com.leetcode.solution;

import java.util.Arrays;

public class productExceptSelf {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation
    */
    public static void main(String[] args) {
        System.out.printf(Arrays.toString(solution(new int[]{1, 2, 3, 4})));
    }

    // Need 2 loop. First is forward loop with i element equal to itself multiple with previous => i element will multiple with all value of all before element
    // Second loop is backward loop with i element equal to itself multiple with previous => i element will multiple with all value of all after element
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int previous = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result[i] *= previous;
            previous *= nums[i];
        }

        return result;
    }
}
