package com.leetcode.solution;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
