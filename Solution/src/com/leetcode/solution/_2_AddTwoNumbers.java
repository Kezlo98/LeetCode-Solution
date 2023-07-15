package com.leetcode.solution;

public class _2_AddTwoNumbers {
    /*
        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.



        Example 1:


        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
        Example 2:

        Input: l1 = [0], l2 = [0]
        Output: [0]
        Example 3:

        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(
                9
        )
        )
        )
        )
        )
        )
        );

        ListNode listNode2 = new ListNode(
                9, new ListNode(
                9, new ListNode(
                9, new ListNode(9)
        )
        )
        );

        ListNode result = addTwoNumbers(listNode1,listNode2);
        System.out.print("Result:\n");
        while (result != null){
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remember = (l1.val + l2.val) / 10;
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode resultNext = result;
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        while (next1 != null || next2 != null) {
            int val = remember;
            if (next1 != null) {
                val += next1.val;
                next1 = next1.next;
            }
            if (next2 != null) {
                val += next2.val;
                next2 = next2.next;
            }
            remember = val / 10;
            resultNext.next = new ListNode(val % 10);
            resultNext = resultNext.next;
        }
        if (remember != 0) {
            resultNext.next = new ListNode(remember);
        }
        return result;
    }
}
