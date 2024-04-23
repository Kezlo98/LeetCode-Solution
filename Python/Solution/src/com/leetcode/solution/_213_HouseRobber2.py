"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
"""


"""
Time complexity: O(n)
Space complexity: 0(1)

Solution:
    DP:
        find max money can rob in single in dex. dp[i] = max(dp[i-1], nums[i] + dp[i-2]) => result = dp[n-1]
        Find the maximum amount of money you can rob from house 1 -> n -1 and from 2 -> n. Then return max value
"""

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(self.helper(nums[1:]), self.helper(nums[:-1]), nums[0])

    def helper(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        h1, h2 = 0, 0
        for num in nums:
            h2, h1 = max(h2, h1 + num), h2
        return h2


if __name__ == '__main__':
    print("Result: ", Solution().rob([21]))
