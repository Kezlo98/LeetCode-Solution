package src.com.leetcode.solution

/*
    You are given an array nums consisting of positive integers.

    We call a subarray of an array complete if the following condition is satisfied:

    The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
    Return the number of complete subarrays.

    A subarray is a contiguous non-empty part of an array.



    Example 1:

    Input: nums = [1,3,1,2,2]
    Output: 4
    Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
    Example 2:

    Input: nums = [5,5,5,5]
    Output: 10
    Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.


    Constraints:

    1 <= nums.length <= 1000
    1 <= nums[i] <= 2000
 */

fun main() {
    val nums = intArrayOf(1786,1786,1786,114)
    println(
        "2799. Count Complete Subarrays in an Array for ${nums.contentToString()}:\t${
            countCompleteSubarrays(
                nums
            )
        }"
    )
}


fun countCompleteSubarrays(nums: IntArray): Int {
    val appearances = mutableMapOf<Int, Int>()
    var maxDis = 0
    for (i in nums.indices) {
        val num = nums[i]
        if (!appearances.containsKey(num)) {
            appearances[num] = 0
            maxDis++
        }
    }

    var curSubLength = maxDis
    var curDis = 0
    var result = 0

    while (curSubLength <= nums.size){
        var l = 0;
        var r = curSubLength - 1;
        val temAppearances = appearances
        for (i in 0 until curSubLength) {
            val num = nums[i]
            if(temAppearances[num] == 0) curDis++
            temAppearances[num] = temAppearances[num]!! + 1
        }
        while (r < nums.size){
            if (curDis == maxDis) result++
            if(temAppearances[nums[l]] == 1) curDis--
            temAppearances[nums[l]] = temAppearances[nums[l]]!! - 1;
            l ++;
            r ++;
            if(r < nums.size){
                if(temAppearances[nums[r]] == 0) curDis++
                temAppearances[nums[r]] = temAppearances[nums[r]]!! + 1;
            }
        }

        curSubLength ++;
    }


    return result
}