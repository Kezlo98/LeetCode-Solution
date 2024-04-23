"""
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
"""
"""

Solution 1:
    DP:
        - Define state: dp[i] = longest increasing subsequence from start to i
        - problem and is sub-problems relation:
            f[i] = max(f[i], f[j] + 1) if:
                j < i
                A[j] < A[i]
        - Base case: dp[0] = 1

Time Complexity: O(n^2)
Space Complexity: O(n)
"""

from typing import List


def lengthOfLIS(nums: List[int]) -> int:
    lis = [1] * len(nums)
    for i in range(1, len(nums)):
        for j in range(i):
            if nums[j] < nums[i]:
                lis[i] = max(lis[i], lis[j] + 1)
    return max(lis)


"""

Solution 2: 
    Ideal is create a lis to store element of nums an maintain increasing subsequence. Only care about 
len, not care about element value 
    Binary Search: 
        - Create a List to store the increasing subsequence: `lis` - Run 
through all element of the nums 
        - Use binary search of cur num index in `lis` => index of closest element which 
larger than cur num 
        - If exist => replace with cur num 
        - If not => add cur num to end of list => return len of lis
        
        Ex: [10,9,2,5,3,7,101,18] lis: []
        
        - 10: [10]
        - 9: [9]
        - 2: [2]
        - 5: [2,5]
        - 3: [2,3]
        - 7: [2,3,7]
        - 101: [2,3,7,101]
        - 18: [2,3,7,18]
        => len(lis) = 4 => result
    
Time Complexity: O(log(n))
Space Complexity: O(n)
    
"""


def lengthOfLISBinarySearch(nums: List[int]) -> int:
    lis = [] * len(nums)
    for num in nums:
        index = binarySearch(lis, num)
        if index >= len(lis):
            lis.append(num)
        else:
            lis[index] = num
    return len(lis)


def binarySearch(nums: List[int], target: int) -> int:
    if len(nums) == 0:
        return 0

    l = 0
    h = len(nums) - 1
    while l <= h:
        m = (l + h) // 2
        if nums[m] > target:
            h = m - 1
        elif nums[m] < target:
            l = m + 1
        else:
            return m
    return l


if __name__ == '__main__':
    print("Result: ", lengthOfLISBinarySearch([10, 9, 2, 5, 3, 7, 101, 18]))
