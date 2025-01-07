package src.com.leetcode.solution;

public class _1444_NumberOfWaysOfCuttingAPizza {
  /*
    Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.

    For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.

    Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.



    Example 1:



    Input: pizza = ["A..","AAA","..."], k = 3
    Output: 3
    Explanation: The figure above shows the three ways to cut the pizza. Note that pieces must contain at least one apple.
    Example 2:

    Input: pizza = ["A..","AA.","..."], k = 3
    Output: 1
    Example 3:

    Input: pizza = ["A..","A..","..."], k = 1
    Output: 1


    Constraints:

    1 <= rows, cols <= 50
    rows == pizza.length
    cols == pizza[i].length
    1 <= k <= 10
    pizza consists of characters 'A' and '.' only.

  */

  public static void main (String[] args) {
    String[] pizza = new String[]{"A..","AAA","..."};
    int k = 3;
    System.out.println(ways(pizza, k));
  }

  public static int ways(String[] pizza, int k) {
    //    Calculate the prefix sum of total apple in the pizza
    int rows = pizza.length;
    int cols = pizza[0].length();
    Integer[][][] dp = new Integer[rows][cols][k];
    int[][] prefixSum = new int[rows + 1][cols + 1];
    for (int i = rows - 1; i >= 0; i--){
      for (int j = cols -1; j >= 0; j --){
        prefixSum[i][j] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
      }
    }

    return dfs(prefixSum, dp,k - 1, 0, 0);
  }

  public static int dfs(int[][] prefixSum, Integer[][][] dp, int k, int r, int c) {
    if(prefixSum[r][c] == 0){
      return 0;
    }
    if(k == 0){
      return 1;
    }
    if(dp[r][c][k] != null){
      return dp[r][c][k];
    }
    int ans = 0;
    // Slide horizontally
    for (int i = r + 1; i < prefixSum.length; i ++){
      if(prefixSum[r][c] - prefixSum[i][c] > 0){
        ans += dfs(prefixSum, dp,k - 1, i, c);
        ans = ans % 1000000007;
      }
    }
    // Slide vertically
    for (int i = c + 1; i < prefixSum[0].length; i ++){
      if(prefixSum[r][c] - prefixSum[r][i] > 0){
        ans += dfs(prefixSum, dp,k - 1, r, i);
        ans = ans % 1000000007;
      }
    }
    dp[r][c][k] = ans;
    return ans;
  }

}
