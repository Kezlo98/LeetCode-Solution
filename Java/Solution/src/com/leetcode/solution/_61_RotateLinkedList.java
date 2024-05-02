package src.com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class _61_RotateLinkedList {

    /*
        Given the head of a linked list, rotate the list to the right by k places.



        Example 1:


        Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]
        Example 2:


        Input: head = [0,1,2], k = 4
        Output: [2,0,1]


        Constraints:

        The number of nodes in the list is in the range [0, 500].
        -100 <= Node.val <= 100
        0 <= k <= 2 * 109
     */

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode node6 = new ListNode(4, tail);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("Result:  ");

        rotateRight(node1,1).printListNode();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode curNode = head;
        int nodeCount = 0;
        while (curNode != null){
            nodeCount++;
            curNode = curNode.next;
        }

        if (nodeCount == 0){
            return head;
        }

        int actualRotateTime = k % nodeCount;

        if(actualRotateTime == 0){
            return head;
        }
        curNode = head;
        int i = nodeCount - actualRotateTime - 1;
        while (i > 0){
            curNode = curNode.next;
            i--;
        }
        ListNode newHead = curNode.next;
        curNode.next = null;
        curNode = newHead;
        while (curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = head;

        return newHead;

    }
}
