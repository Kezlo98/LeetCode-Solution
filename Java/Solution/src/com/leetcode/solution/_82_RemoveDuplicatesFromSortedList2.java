package src.com.leetcode.solution;

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

        System.out.printf("Result  ");

        while (listNode != null){
            System.out.printf(listNode.val + "  ");
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode resultHead = new ListNode(-101);
        ListNode curResult = null;

        ListNode prevNode = resultHead;
        ListNode curNode = head;

        while (curNode != null){
            if(curNode.val != prevNode.val &&
            (curNode.next == null || curNode.val != curNode.next.val)){
                curResult = new ListNode(curNode.val);
                resultHead.next = curResult;
            }

            prevNode = curNode;
            curNode = curNode.next;
            if(curResult != null){
                break;
            }
        }

        if(curResult == null){
            return resultHead.next;
        }

        while (curNode != null){
            if(curNode.val != prevNode.val &&
                    (curNode.next == null || curNode.val != curNode.next.val)){
                curResult.next = new ListNode(curNode.val);
                curResult = curResult.next;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }

        return resultHead.next;

    }
}
