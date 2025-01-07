package src.com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class SortLinkedListAlreadySortedUsingAbsoluteValues {

  /*
  Given a linked list that is sorted based on absolute values. Sort the list based on actual values.

  Examples:

  Input :  1 -> -10
  output: -10 -> 1

  Input : 1 -> -2 -> -3 -> 4 -> -5
  output: -5 -> -3 -> -2 -> 1 -> 4

  Input : -5 -> -10
  Output: -10 -> -5

  Input : 5 -> 10
  output: 5 -> 10
  */

  public static void main (String[] args) {
    ListNode head = ListNode.createListNode(new int[]{1, -2, -3, 4, -5});
    ListNode result = sortLinkedListAlreadySortedUsingAbsoluteValues(head);
    result.printListNode();
  }

  public static ListNode sortLinkedListAlreadySortedUsingAbsoluteValues (ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode node = head;
    ListNode temp;
    List<ListNode> nodes = new ArrayList<>();
    while (node != null){
      nodes.add(node);
      temp = node;
      node = node.next;
      temp.next = null;
    }
    return divideAndConq(nodes, 0, nodes.size() - 1);
  }

  public static ListNode divideAndConq(List<ListNode> node, int start, int end){
    if(start == end){
      return node.get(start);
    }
    int mid = start + (end - start) / 2;
    ListNode left = divideAndConq(node, start, mid);
    ListNode right = divideAndConq(node, mid + 1, end);
    return merge(left, right);

  }
  public static ListNode merge(ListNode left, ListNode right){
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;

    while (left != null && right != null) {
      if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }

    if (left != null) {
      cur.next = left;
    }

    if (right != null) {
      cur.next = right;
    }

    return dummy.next;
  }

}
