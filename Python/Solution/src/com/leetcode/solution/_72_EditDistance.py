"""
72. Edit Distance
Medium
Topics
Companies
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
"""

"""
Solution:
    DP:
        - Base case: dp[i][0] = i
                     dp[0][i] = i
        - Define: dp[i][j] => number of operations required to convert word1[0:i] to word2[0:j]
        - Relate:
            + If word1[i] == word2[j] => (i++, j++)
            + If not:
                + insert: insert word2[j] to word1 in i position <=> act as word2[j] is covered
                    =>    same with case 1 but increase only j
                    =>    work same as insert word1 to word2
                    =>    min of both way => dp[i][j] = min(dp[i+1][j] + 1,dp[i,j+1] + 1)
                + delete: same as insert
                + replace: choose i or j to be replaced
                    + dp[i][j] = dp[i+1][j+1] + 1
        
        => need to compare dp[i][j] = min(dp[i+1][j], dp[i+1][j+1], dp[i][j+1]) + 1
"""


def minDistance(word1: str, word2: str) -> int:
    n = len(word1)
    m = len(word2)
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        dp[i][0] = i
    for j in range(1, m + 1):
        dp[0][j] = j

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if word1[i - 1] == word2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1

    return dp[n][m]


if __name__ == '__main__':
    print("Result: ", minDistance("horse", "ros"))
