"""
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
"""
from turtledemo.rosette import mn_eck
from typing import List


def minSubArrayLen(target: int, nums: List[int]) -> int:
  first_index = 0
  _sum = 0
  min_range = len(nums) + 1

  for i in range(0, len(nums)):
    _sum += nums[i]
    while _sum >= target:
      min_range = min(min_range, i - first_index + 1)
      _sum -= nums[first_index]
      first_index += 1

  return 0 if min_range == len(nums) + 1 else min_range


if __name__ == '__main__':
    print("Result: ", minSubArrayLen(7,[2,3,1,2,4,3]))