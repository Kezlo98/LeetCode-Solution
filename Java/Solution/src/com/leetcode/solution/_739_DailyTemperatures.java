package com.leetcode.solution;

import java.util.Stack;

public class _739_DailyTemperatures {
    /*
        Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



        Example 1:

        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]
        Example 2:

        Input: temperatures = [30,40,50,60]
        Output: [1,1,1,0]
        Example 3:

        Input: temperatures = [30,60,90]
        Output: [1,1,0]


        Constraints:

        1 <= temperatures.length <= 105
        30 <= temperatures[i] <= 100
     */

    public static void main(String[] args) {
        int[] temperatures = {30,60,90};
        int[] ints = dailyTemperatures(temperatures);
        System.out.print("Result");
        for(int i : ints){
            System.out.print(" " + i);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        tempStack.push(temperatures[0]);
        indexStack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!tempStack.isEmpty() && tempStack.peek() < temperatures[i]){
                int index = indexStack.pop();
                result[index] = i - index;
                tempStack.pop();
            }
            tempStack.push(temperatures[i]);
            indexStack.push(i);
        }

        return result;
    }
}
