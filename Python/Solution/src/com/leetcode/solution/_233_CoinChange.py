"""
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.



    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0


    Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104
"""

"""
Time Complexity: O(n*m)
Space Complexity: O(n)

Solution:
    Explanation: 
        To find how many coin need to make up that amount => try every way with given coin value
        EX: [1,2,5], amount = 11
        1_value: = 1 + 10 => min_coin(11) = 1 coin 1_value + min_coin(10)
        2_value: = 2 + 9 => min_coin(11) = 1 coin 2_value + min_coin(9)
        5_value: = 5 + 5 => min_coin(11) = 1 coin 5_value + min_coin(5)
        => min(11) = 1 + min(min_coin(10), min_coin(9), min_coin(5))
        => find min_coin of 10, 9 and 5
        => find min coin all value from 1 to amount
"""

from typing import List


def coinChange(coins: List[int], amount: int) -> int:
    dp = [0] * (amount + 1)

    for i in range(1, amount + 1):
        min_coin = float('inf')
        for coin in coins:
            if coin == i:
                min_coin = 1
                break
            elif i > coin:
                if dp[i] != float('inf'):
                    min_coin = min(dp[i - coin] + 1, min_coin)
        dp[i] = min_coin
    return -1 if dp[-1] == float('inf') else dp[-1]


if __name__ == '__main__':
    print("Result: ", coinChange([1, 2, 5], 11))
