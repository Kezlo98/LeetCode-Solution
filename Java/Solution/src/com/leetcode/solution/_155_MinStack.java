package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class _155_MinStack {
    /*
        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        Implement the MinStack class:

        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        You must implement a solution with O(1) time complexity for each function.



        Example 1:

        Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

        Output
        [null,null,null,null,-3,null,0,-2]

        Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2


        Constraints:

        -231 <= val <= 231-1
        Methods pop, top and getMin operations will always be called on non-empty stacks.
        At most 3 * 104 calls will be made to push, pop, top, and getMin.
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        printLn(minStack.top());
        minStack.pop();
        printLn(minStack.getMin()); // return -3
        minStack.pop();
        printLn(minStack.getMin()); // return 0
        minStack.pop();
        minStack.push(2147483647);
        printLn(minStack.top());
        printLn(minStack.getMin()); // return -2;
        minStack.push(-2147483648);
        printLn(minStack.top());
        printLn(minStack.getMin());
        minStack.pop();
        printLn(minStack.getMin());
    }

    static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(minStack.isEmpty() ? val : Math.min(minStack.peek(),val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();

        }
    }

    private static void printLn(int val){
        System.out.printf("\n" + val);
    }
}
