package com.leetcode.solution;

public class _92_ReverseLinkedList2 {
    /*
        Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.



        Example 1:


        Input: head = [1,2,3,4,5], left = 2, right = 4
        Output: [1,4,3,2,5]
        Example 2:

        Input: head = [5], left = 1, right = 1
        Output: [5]


        Constraints:

        The number of nodes in the list is n.
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n


        Follow up: Could you do it in one pass?
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        head.next = _2;
        _2.next=_3;
        _3.next=_4;
        _4.next=_5;


        ListNode listNode = reverseBetween(head, 2, 4);

        System.out.printf("Hold");

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode node = head;
        ListNode preNode = null;

        ListNode preFirstNode = null;
        ListNode firstNode = null;
        ListNode lastNode = null;
        ListNode postLastNode = null;

        while (count != left){
            count ++;
            preNode = node;
            node = node.next;
        }

        while (left <= count && count <= right){
            if(count == left){
                preFirstNode = preNode;
                firstNode = node;
            }
            if (count == right){
                lastNode = node;
                postLastNode = lastNode.next;
            }
            ListNode temp = node.next;
            node.next = preNode;
            preNode = node;
            node = temp;
            count ++;
        }
        firstNode.next = postLastNode;
        if(preFirstNode != null){
            preFirstNode.next = lastNode;
        } else {
            head = lastNode;
        }

        return head;
    }
}
