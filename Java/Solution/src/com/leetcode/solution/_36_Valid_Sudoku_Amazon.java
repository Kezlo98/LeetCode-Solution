package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _36_Valid_Sudoku_Amazon {

    /*
            Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

            Each row must contain the digits 1-9 without repetition.
            Each column must contain the digits 1-9 without repetition.
            Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
            Note:

            A Sudoku board (partially filled) could be valid but is not necessarily solvable.
            Only the filled cells need to be validated according to the mentioned rules.


            Example 1:


            Input: board =
            [["5","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
            Output: true
            Example 2:

            Input: board =
            [["8","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
            Output: false
            Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     */

    public static void main(String[] args) {
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board = {  {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'3', '.', '.', '.', '4', '6', '5', '.', '.'},
                            {'.', '.', '5', '.', '2', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '3', '.', '.', '.', '.', '.', '.', '1'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                            {'.', '.', '.', '.', '.', '5', '.', '6', '.'},
                            {'.', '.', '.', '9', '.', '.', '.', '.', '.'}};


        System.out.println("Result: " + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean> isRowExisted = new HashMap<>();
        HashMap<Character, Boolean> isColumnExisted = new HashMap<>();
        HashMap<List<Integer>, List<Character>> is3x3Existed = new HashMap<>();

        // Checking Column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (isColumnExisted.containsKey(board[i][j])) {
                        return false;
                    } else {
                        isColumnExisted.put(board[i][j], true);
                    }
                    if (is3x3NotExisted(is3x3Existed, i, j, board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (isRowExisted.containsKey(board[j][i])) {
                        return false;
                    } else {
                        isRowExisted.put(board[j][i], true);
                    }
                }
            }
            isColumnExisted = new HashMap<>();
            isRowExisted = new HashMap<>();
        }

        return true;
    }

    private static boolean is3x3NotExisted(HashMap<List<Integer>, List<Character>> is3x3Existed, int column, int row, char value) {
        List<Integer> squareIndex = Arrays.asList(column / 3, row / 3);
        if (is3x3Existed.containsKey(squareIndex)) {
            if (is3x3Existed.get(squareIndex).contains(value)) {
                return true;
            } else {
                is3x3Existed.get(squareIndex).add(value);
            }
        } else {
            List<Character> exist = new ArrayList<>();
            exist.add(value);
            is3x3Existed.put(squareIndex, exist);
        }
        return false;
    }

}
