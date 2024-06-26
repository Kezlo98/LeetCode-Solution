package src.com.leetcode.solution

/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.



    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]



    Constraints:

        n == nums.length
        1 <= n <= 300
        nums[i] is either 0, 1, or 2.



    Follow up: Could you come up with a one-pass algorithm using only constant extra space?

 */

fun main() {
    var nums = intArrayOf(2);
    sortColors(nums);
    print("Result: ")
    for(num in nums){
        print(" $num")
    }
}

fun sortColors(nums: IntArray): Unit {
    var l = 0;
    var r = nums.size - 1;
    var i = 0;
    while (i <= r){
        if(nums[i] == 2){
                swap(nums,i,r)
                r --;
        } else {
            if (nums[i] == 0) {
                swap(nums, l, i)
                l++
            }
            i++
        }
    }
}

fun swap(nums: IntArray, l: Int, r: Int): Unit{
    val temp = nums[l]
    nums[l] = nums[r]
    nums[r] = temp
}