package com.leetcode.solution;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _82_RemoveDuplicatesFromSortedList2 {

    /*
        Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



        Example 1:


        Input: head = [1,2,3,3,4,4,5]
        Output: [1,2,5]
        Example 2:


        Input: head = [1,1,1,2,3]
        Output: [2,3]


        Constraints:

        The number of nodes in the list is in the range [0, 300].
        -100 <= Node.val <= 100
        The list is guaranteed to be sorted in ascending order.
     */

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode node6 = new ListNode(4, tail);
        ListNode node5 = new ListNode(3);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode listNode = deleteDuplicates(node1);

        System.out.printf("Result");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            if (head.val == head.next.val){
                return null;
            }
        }

        int prevValue = head.val;
        head = head.next;
        while ((prevValue == head.val) || (head.next == null) || (head.val == head.next.val)){
            prevValue = head.val;
            head = head.next;
        }

        ListNode node = new ListNode(-101, head);
        ListNode firstNode = node.next;
        ListNode preSecondNode = head;
        ListNode secondNode = head.next;

        while (secondNode != null) {
            if (preSecondNode.val != secondNode.val) {
                if ((secondNode.next == null) || (secondNode.next.val != secondNode.val)) {
                    firstNode.next = secondNode;
                    firstNode = firstNode.next;
                }
            }

            preSecondNode = secondNode;
            secondNode = secondNode.next;
        }

        return node.next;
    }
}
