"""
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.



Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.


Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
"""
from typing import List

"""

Solution: 
    DP:
        - Define: dp[i] => Longest increasing subsequence from start to i
        - Base case: dp[0] = 1
        - Relative: dp[i] = max(dp[i], dp[j]) if j < i and nums[j] < num[i]

"""


def findNumberOfLIS(nums: List[int]) -> int:
    dp = [1] * len(nums)
    count = [1] * len(nums)
    count[0] = 1
    for i in range(1, len(nums)):
        for j in range(i):
            if nums[i] > nums[j]:
                if dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1
                    count[i] = count[j]
                elif dp[i] == dp[j] + 1:
                    count[i] += count[j]

    return count[max(dp)]


if __name__ == '__main__':
    print("Result: ", findNumberOfLIS([1, 3, 5, 4, 7]))
