package com.leetcode.solution
/*
    Given a 2D matrix matrix, handle multiple queries of the following type:

        Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Implement the NumMatrix class:

        NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
        int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    You must design an algorithm where sumRegion works on O(1) time complexity.



    Example 1:

    Input
    ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    Output
    [null, 8, 11, 12]

    Explanation
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

 */

fun main() {
//    val numMatrix = NumMatrix(
//        arrayOf(
//            intArrayOf(3, 0, 1, 4, 2),
//            intArrayOf(5, 6, 3, 2, 1),
//            intArrayOf(1, 2, 0, 1, 5),
//            intArrayOf(4, 1, 0, 1, 7),
//            intArrayOf(1, 0, 3, 0, 5),
//        )
//    )
//
//    println("(2,1) - (4,3): ${numMatrix.sumRegion(2,1,4,3)}")
//    println("(1,1) - (2,2): ${numMatrix.sumRegion(1,1,2,2)}")
//    println("(1,2) - (2,4): ${numMatrix.sumRegion(1,2,2,4)}")

    val numMatrix = NumMatrix(
        arrayOf(
            intArrayOf(-4,-5),
        )
    )

    println("(0,0) - (0,0): ${numMatrix.sumRegion(0,0,0,0)}")
    println("(0,0) - (0,1): ${numMatrix.sumRegion(0,0,0,1)}")
    println("(0,1) - (0,1): ${numMatrix.sumRegion(0,1,0,1)}")
}

class NumMatrix {

    val matrix: Array<IntArray>
    val presum: Array<IntArray>

    constructor(matrixInit: Array<IntArray> ) {
        matrix = matrixInit
        presum = Array(matrix.size) {
            IntArray(matrix[0].size)
        }

        presum[0][0] = matrix[0][0]
        for (i in 1..<matrix.size){
            presum[i][0] = presum[i-1][0] + matrix[i][0]
        }
        for (i in 1..<matrix[0].size){
            presum[0][i] = presum[0][i-1] + matrix[0][i]
        }

        for (i in 1..<matrix.size){
            for (j in 1..<matrix[0].size){
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var result = presum[row2][col2]
        if (row1  != 0 ){
            result -= presum[row1-1][col2]
        }
        if (col1 != 0){
            result -= presum[row2][col1-1]
        }
        if(row1 != 0 && row2 != 0){
            result += presum[row1-1][col1-1]
        }
        return result
    }

}