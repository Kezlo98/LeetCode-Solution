"""
Description
If the depth of a tree is smaller than 5, then this tree can be represented by an array of three-digit integers. For each integer in this array:

The hundreds digit represents the depth d of this node where 1 <= d <= 4.
The tens digit represents the position p of this node in the level it belongs to where 1 <= p <= 8. The position is the same as that in a full binary tree.
The units digit represents the value v of this node where 0 <= v <= 9.
Given an array of ascending three-digit integers nums representing a binary tree with a depth smaller than 5, return the sum of all paths from the root towards the leaves.

It is guaranteed that the given array represents a valid connected binary tree.



Example 1:



Input: nums = [113,215,221]
Output: 12
Explanation: The tree that the list represents is shown.
The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:



Input: nums = [113,221]
Output: 4
Explanation: The tree that the list represents is shown.
The path sum is (3 + 1) = 4.


Constraints:

1 <= nums.length <= 15
110 <= nums[i] <= 489
nums represents a valid binary tree with depth less than 5.
nums is sorted in ascending order.

[113, 211, 225, 322, 334,346]

"""
from typing import List


def path_sum(nums: List[int]) -> int:
  return 0

def dfs(nums: List[int], sum: int, level: int, pos: int) -> int:
  levelIndex = 0
  firstLeafMaxValue = (level*100 + (pos * 2 - 1) + 9)
  secondLeafMaxValue = (level*100 + (pos * 2) + 9)
  sum = 0
  for i in range (0, len(nums)):
    if nums[i] >= ((level + 1) * 100):
      levelIndex = i
      sum += 
      break
    if nums <= firstLeafMaxValue:
      break
    elif firstLeafMaxValue < nums <= secondLeafMaxValue:
      break
  return sum

if __name__ == '__main__':
  print("Result: ", path_sum([]))
