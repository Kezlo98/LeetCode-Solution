package com.leetcode.solution;

public class _74_SearchA2DMatrix {
    /*
        You are given an m x n integer matrix matrix with the following two properties:

        Each row is sorted in non-decreasing order.
        The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.

        You must write a solution in O(log(m * n)) time complexity.



        Example 1:


        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true
        Example 2:


        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false


        Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -104 <= matrix[i][j], target <= 104
     */

    public static void main(String[] args) {
        int[][] matrix = {{1,1}};
        System.out.printf("Result: " + searchMatrix(matrix,2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // Find a possible row target could be
        int left = 0;
        int right = rowLength - 1;
        int possibleRowIndex = rowLength;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(matrix[mid][0] <= target && matrix[mid][columnLength-1] >= target){
                if(matrix[mid][0] == target || matrix[mid][columnLength-1] == target){
                    return true;
                }
                possibleRowIndex = mid;
                break;
            } else if (matrix[mid][0] > target){
                right --;
            } else if (matrix[mid][columnLength-1] < target){
                left ++;
            }
        }

        if(possibleRowIndex == rowLength){
            return false;
        }

        int[] row = matrix[possibleRowIndex];

        left = 0;
        right = columnLength - 1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(row[mid] == target){
                return true;
            } else if (row[mid] < target){
                left ++;
            } else {
                right --;
            }
        }

        return false;
    }
}
