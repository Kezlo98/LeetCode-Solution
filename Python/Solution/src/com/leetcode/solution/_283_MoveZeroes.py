"""
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
"""
from typing import List


def move_zeroes(nums: List[int]) -> None:
  zero_index = 0
  for i in range(len(nums)):
    if nums[i] != 0:
      if i != zero_index:
        nums[i] = nums[i] + nums[zero_index]
        nums[zero_index] = nums[i] - nums[zero_index]
        nums[i] = nums[i] - nums[zero_index]
      zero_index += 1


if __name__ == '__main__':
  nums = [1]
  move_zeroes(nums)
  print("Result: ", nums)
