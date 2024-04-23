package com.leetcode.solution

/*
    You are given an integer array nums sorted in non-decreasing order.

    Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.

    In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).



    Example 1:

    Input: nums = [2,3,5]
    Output: [4,3,5]
    Explanation: Assuming the arrays are 0-indexed, then
    result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
    result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
    result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
    Example 2:

    Input: nums = [1,4,6,8,10]
    Output: [24,15,13,15,21]


    Constraints:

    2 <= nums.length <= 105
    1 <= nums[i] <= nums[i + 1] <= 104
 */

fun main() {
    val result = getSumAbsoluteDifferences(intArrayOf(2, 3, 5))
    println("Result: ")
    for (re in result) {
        println(re)
    }
}

fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    var totalSum = 0
    for (num in nums) {
        totalSum += num
    }
    val result = IntArray(nums.size)

    var prefixSum = 0

    for (i in nums.indices) {
        /*
            Because nums list is sorted in ascending order
            Result at index i = leftSideSum + rightSideSum
            leftSideSum: Only contain value less or equal with cur value => absolute will be (cur - elementFromLeft) => leftSideSum = cur*i - (totalSum of all left element => prefix sum)
            rightSideSum: Only contain value larger or equal with cur value => absolute will be (elementFromRight - cur) => leftSideSum = (totalSum of all left element => total sum - cur value - prefix sum) - cur value * (n - index -1)
         */
        val curSum =
            nums[i] * i - prefixSum + (totalSum - prefixSum - nums[i]) - nums[i] * (nums.size - i - 1)
        prefixSum += nums[i]
        result[i] = curSum

    }

    return result
}