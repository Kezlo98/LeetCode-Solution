"""
1312. Minimum Insertion Steps to Make a String Palindrome
Hard
Topics
Companies
Hint
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.



Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
"""
from com.leetcode.solution._516_LongestPalidromeSubsequence import longestPalindromeSubseq

"""
Solution:
    DP: 
        - Find longestPalindromeSubseq
        - Result = len(s) - longestPalindromeSubseq
"""


def minInsertions(s: str) -> int:
    return len(s) - longestPalindromeSubseq(s)


if __name__ == '__main__':
    print("Result = ", minInsertions("leetcode"))
