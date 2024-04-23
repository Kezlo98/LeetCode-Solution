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


def longestPalindromeSubseq(s: str) -> int:
    revert = s[::-1]
    dp = [[0 for _ in range(len(revert) + 1)] for _ in range(len(s) + 1)]

    for i in range(len(s) - 1, -1, -1):
        for j in range(len(revert) - 1, -1, -1):
            if s[i] == revert[j]:
                dp[i][j] = dp[i + 1][j + 1] + 1
            else:
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1])
    return dp[0][0]


if __name__ == '__main__':
    print("Result: {}".format(longestPalindromeSubseq("cbbd")))

"""
Solution:
    To find the longest palindromic, we can revert current str => find longest Common Sequence with current str and it revert
    => result

Time Complexity: O(n)
Space Complexity: O(n)
"""