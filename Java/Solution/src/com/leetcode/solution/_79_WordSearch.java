package src.com.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _79_WordSearch {

  /*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



    Example 1:


    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true
    Example 2:


    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true
    Example 3:


    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false


    Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.


    Follow up: Could you use search pruning to make your solution faster with a larger board?
  */

  /*
    Solution: Backtracking - DFS
    - Convert the word to char array
    - Iterate through the board
    - For each cell, check if the cell is equal to the first character of the word
    - If it is, perform a depth first search to check if the word can be formed from the cell
    - If the word can be formed, return true
    - If the word cannot be formed, return false
    Time Complexity: O(m * n * 4^s) where m is the number of rows, n is the number of columns and s is the length of the word
  */

  public static void main (String[] args) {
    char[][] board = {
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };
    String word = "ABCB";
    System.out.println(exist(board, word));
  }

  public static boolean exist(char[][] board, String word) {
    char[] chars =  word.toCharArray();
    Set<String> path = new HashSet<>();
    for (int i = 0; i < board.length; i ++){
      for (int j = 0; j < board[0].length; j ++){
        if(dfs(i, j, 0, board, chars, path)){
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(int r, int c, int i, char[][] board, char[] chars, Set<String> path){
    if (i == chars.length) return true;
    if(r == board.length || r < 0 || c == board[0].length || c < 0){
      return false;
    }
    if(board[r][c] != chars[i]) return false;
    if (path.contains(r + "" + c)) return false;
    path.add(r + "" + c);
    boolean isMatch = dfs(r + 1, c, i + 1, board, chars, path) || dfs(r - 1, c, i + 1, board, chars, path) || dfs(r, c + 1, i + 1, board, chars, path) || dfs(r, c - 1, i + 1, board, chars, path);
    path.remove(r + "" + c);

    return isMatch;
  }

}
