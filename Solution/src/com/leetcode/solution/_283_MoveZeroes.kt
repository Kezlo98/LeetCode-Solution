package com.leetcode.solution

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:

    Input: nums = [0]
    Output: [0]



    Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?
 */

fun main() {
    var nums = intArrayOf(0,1,0,3,12)
    moveZeroes(nums)
    println("Result")
    for (num in nums){
        println(num)
    }
}

fun moveZeroes(nums: IntArray): Unit {
    if (nums.size <= 1){
        return
    }

    var left = 0;
    var right = 0;

    while (left < nums.size && right < nums.size) {

        if (nums[left] != 0 ) {
            left++
        }

        if (nums[right] == 0) {
            right++
        }

        if ((left < nums.size) and (right < nums.size) and  (left < right)){
            nums[left] = nums[left] + nums[right]
            nums[right] = nums[left] - nums[right]
            nums[left] = nums[left] - nums[right]
        }
    }
}