package com.leetcode.solution.topInterviewQuestions;

public class sqrt {

  public static void main(String[] args) {
    System.out.printf(String.valueOf(mySqrt(4)));
  }

  public static int mySqrt(int x) {

    if(x == 1) return x;

    int leftPtr = 1;
    int rightPtr = x/2;
    int result = 0;
    int mid = 0;

    while (leftPtr <= rightPtr){
      mid = (leftPtr + rightPtr)/2;
      long temp = (long)mid * (long)mid;

      if(temp == x){
        return mid;
      } else if (temp < x){
        leftPtr = mid + 1;
        result = mid;
      } else {
        rightPtr = mid -1;
      }
    }

    return result;
  }

}
