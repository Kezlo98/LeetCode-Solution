"""
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
"""

"""
Solution:
    DP:
        - Base case: 
            + dp[i][i] = 1
            + if i > j => return 0
        - dp: palindromic substrings count from i to j
        - Relative:
            + s[i] == s[j] => dp[i][j] = dp[i+1][j-1]
            + s[i] != s[j] => dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
"""


def countSubstrings(s: str) -> int:
    result = 0
    for i in range(len(s)):
        shift = 1
        while i - shift >= 0 and i + shift < len(s) and s[i-shift] == s[i+shift]:
            shift += 1
        result += shift
        shift = 0
        while i - shift >= 0 and i + shift + 1 < len(s) and s[i-shift] == s[i+shift+1]:
            shift += 1
        result += shift
    return result


if __name__ == '__main__':
    print(countSubstrings("aaa"))
