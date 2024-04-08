"""
Given an integer array nums, find a 
subarray
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
"""

"""
Solution:
    Explanation:
        If subarray only contain positive => always increase product of the subarray. [1,2,4,5,6] => max = 240
        If subarray only contain negative => will be positive if negative number is even. [-1,-2,-3,-4] => max = 24
        => we can store curMax and curMin.
            - curMax is maximum product of the subarray in current index
            - curMin is minimum product of the subarray in current index
            - curMax = max(cur, curMax * cur, curMin * cur):
                + When curMin negative and cur is negative => chance that curMax is curMin*cur
                + When curMax negative and cur is positive => chance that curMax is cur
                + When curMax positive and cur is positive => chance that curMax is curMax*cur
            - curMin = max(cur, curMax * cur, curMin * cur)
            - when cur = 0 => act cur = 1 => reset curMax and curMin to 1,1
            - res = max(res, curMax)
    
Time Complexity: O(N)
Space Complexity: O(1)
"""

from typing import List


def maxProduct(nums: List[int]) -> int:
    res = max(nums)
    curMax, curMin = 1, 1

    for num in nums:
        if num == 0:
            curMax, curMin = 1, 1
            continue
        temp = num * curMax
        curMax = max(num, temp, num * curMin)
        curMin = min(num, temp, num * curMin)
        res = max(curMax, res)
    return res


if __name__ == '__main__':
    print("Result: ", maxProduct([2, 3, -2, 4]))
