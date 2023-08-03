package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class _19_RemoveNthNodeFromEndOfLinkedList {
    /*
        Given the head of a linked list, remove the nth node from the end of the list and return its head.



        Example 1:


        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
        Example 2:

        Input: head = [1], n = 1
        Output: []
        Example 3:

        Input: head = [1,2], n = 1
        Output: [1]


        Constraints:

        The number of nodes in the list is sz.
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
     */

    public static void main(String[] args) {
        ListNode tail = new ListNode(2);
        ListNode head = new ListNode(1,tail);

        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.printf("Result");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> nodeArray = new ArrayList<>();

        while (node != null){
            nodeArray.add(node);
            node = node.next;
        }

        int preIndex = nodeArray.size() - n - 1;
        int nextIndex = nodeArray.size() - n + 1;

        ListNode nextNode = nextIndex >= nodeArray.size() ?
                null :
                nodeArray.get(nodeArray.size() - n + 1);

        ListNode preNode = preIndex < 0 ? null : nodeArray.get(preIndex);

        if(preNode == null){
            return nextNode;
        }

        preNode.next = nextNode;

        return head;
    }
}
