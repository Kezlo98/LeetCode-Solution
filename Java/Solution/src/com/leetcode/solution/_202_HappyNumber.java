package src.com.leetcode.solution;

import java.util.HashMap;

public class _202_HappyNumber {
    /*
        Write an algorithm to determine if a number n is happy.

        A happy number is a number defined by the following process:

        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.



        Example 1:

        Input: n = 19
        Output: true
        Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1
        Example 2:

        Input: n = 2
        Output: false


        Constraints:

        1 <= n <= 231 - 1
     */

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Result: " + isHappy(n));
    }

    public static boolean isHappy(int n){
        HashMap<Integer, Boolean> tracking = new HashMap<>();
        int newNum = 0;
        int tempNum = n;
        while (true) {
            while (tempNum > 0) {
                newNum += (tempNum % 10) * (tempNum % 10);
                tempNum = tempNum / 10;
            }
            if (newNum == 1) {
                return true;
            }
            if (tracking.containsKey(newNum)) {
                return false;
            } else {
                tracking.put(newNum, true);
            }
            tempNum = newNum;
            newNum = 0;
        }

    }
}
