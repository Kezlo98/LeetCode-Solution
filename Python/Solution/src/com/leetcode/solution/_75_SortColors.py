"""
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
"""
from typing import List


def sortColors(nums: List[int]) -> None:
  zeroIndex = 0
  twoIndex = len(nums) - 1
  i = 0
  while i < len(nums):
    if nums[i] == 0:
      if i > zeroIndex:
        nums[zeroIndex] = nums[zeroIndex] + nums[i]
        nums[i] = nums[zeroIndex] - nums[i]
        nums[zeroIndex] = nums[zeroIndex] - nums[i]
      zeroIndex += 1
    elif nums[i] == 2:
      if i < twoIndex:
        nums[twoIndex] = nums[twoIndex] + nums[i]
        nums[i] = nums[twoIndex] - nums[i]
        nums[twoIndex] = nums[twoIndex] - nums[i]
        twoIndex -= 1
        i -= 1
    i += 1


if __name__ == '__main__':
  l = [0, 1, 0]
  sortColors(l)
  print("Result: ", l)
