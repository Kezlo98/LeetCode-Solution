"""
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
"""

"""
Solution: - For loop for all char in str: 
    + 2 type of palindromic: 
        + palindromic with odd length: cbabc 
            + Take current char is middle (i), find longest palindromic substring surround middle by check left and right is same
            + compare length with result => update result if length is longer
        + palindromic with even length: baab:
            + Take current char and next char is middle (i and i + 1), find longest palindromic substring surround middle by check left and right is same
            + compare length with result => update result if length is longer
Time Complexity: O(n^2)
Space Complexity: O(n)
"""


def longestPalindrome(s: str) -> str:
    result = ""
    for i in range(len(s)):
        shift = 0
        while i - shift >= 0 and i + shift < len(s) and s[i - shift] == s[i + shift]:
            shift += 1
        result = s[i + 1 - shift: i + shift] if 2*shift - 1 - shift > len(result) else result
        shift = 0
        while i - shift >= 0 and i + shift + 1 < len(s) and s[i - shift] == s[i + shift + 1]:
            shift += 1
        result = s[i + 1 - shift: i + shift + 1] if 2 * shift > len(result) else result
    return result


if __name__ == '__main__':
    print("Result = ", longestPalindrome("babad"))
