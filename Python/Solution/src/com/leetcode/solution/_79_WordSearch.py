from typing import List

'''
    Solution: Backtracking - DFS
    - Convert the word to char array
    - Iterate through the board
    - For each cell, check if the cell is equal to the first character of the word
    - If it is, perform a depth first search to check if the word can be formed from the cell
    - If the word can be formed, return true
    - If the word cannot be formed, return false
    Time Complexity: O(m * n * 4^s) where m is the number of rows, n is the number of columns and s is the length of the word
'''

def exist(board: List[List[str]], word: str) -> bool:
  rows, cols = len(board), len(board[0])
  path = set()

  def dfs(r,c,i):
    if i == len(word):
      return True

    if r < 0 or r == rows or c < 0 or c == cols or board[r][c] != word[i] or (r,c) in path :
      return False

    path.add((r,c))

    is_exist = dfs(r+1, c, i + 1) or dfs(r - 1, c, i + 1) or dfs(r, c + 1, i + 1) or dfs(r, c - 1, i + 1)

    path.remove((r,c))

    return is_exist

  for r in range (0, rows):
    for c in range (0, cols):
      if dfs(r,c,0):
        return True

  return False

if __name__ == '__main__':
  board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
  word = "ABCB"
  print("Result: ", exist(board, word))
