"""
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1" 'B' -> "2" ... 'Z' -> "26" To decode an encoded message, all the digits must be grouped then mapped back
into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped
into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").


Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
"""

"""
Time complexity: O(n)
Space complexity: O(n)

Solution:   DP
    Example: 226
        For first index => i = 0 => s[0] = 2 => we can decode 2 way : 2 (B) or 22(V)
        => That mean, for 226, we can have 2 possible decode ways:
            -   B 26 = 1 + decodeWays(26)
            -   V 6 = 1 + decodeWays(6) (Only have if we can create 2 digit decode)
        => Total result = 1 + decodeWays(26) + 1 + decodeWays(6)

    DP:
        dp = {} => store how many ways to decode from that index to these end of string
        s[i] = '0' => dp[i] = 0
        s[i] != '0'=> dp[i] = 1 + dp[i+1]
        if s[i]s[i+1] can decode => dp[i] = 1 + dp[i+1] + dp[i+2]

"""


def numDecodings(s: str) -> int:
    # Init array with all 1
    dp = {len(s): 1}
    for i in range(len(s) - 1, -1, -1):
        #  If s[i] = 0 => can not be decoded itself => d[i] = 0
        if s[i] == '0':
            dp[i] = 0
        else:
            dp[i] = dp[i + 1]

        if i + 1 < len(s) and (s[i] == "1" or s[i] == 2 and s[i + 1] in "0123456"):
            dp[i] += dp[i + 2]

    return dp[0]


if __name__ == '__main__':
    print("Result: ", numDecodings("10"))
