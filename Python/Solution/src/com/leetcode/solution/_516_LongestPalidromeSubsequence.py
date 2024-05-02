"""
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".


Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
"""
from Solution.src.com.leetcode.solution._1143_LongestCommonSubsequence import \
    longestCommonSubsequence

"""
Solution:
    To find the longest palindromic, we can revert current str => find longest Common Sequence with current str and it revert
    => result

Time Complexity: O(n)
Space Complexity: O(n)
"""


def longestPalindromeSubseq(s: str) -> int:
    revert = s[::-1]
    return longestCommonSubsequence(s, revert)


if __name__ == '__main__':
    print("Result: {}".format(longestPalindromeSubseq("cbbd")))

