package src.com.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_MergeKSortedLists {

  /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.



    Example 1:

    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
    Example 2:

    Input: lists = []
    Output: []
    Example 3:

    Input: lists = [[]]
    Output: []


    Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.
  */

  public static void main (String[] args) {
    ListNode[] lists = new ListNode[3];
    lists[0] = ListNode.createListNode(new int[]{1, 4, 5});
    lists[1] = ListNode.createListNode(new int[]{1, 3, 4});
    lists[2] = ListNode.createListNode(new int[]{2, 6});

//    ListNode result = mergeKListsUsingHeap(lists);
    ListNode result = mergeKListsUsingDivineAndConquer(lists);
    result.printListNode();
  }

  public static ListNode mergeKListsUsingDivineAndConquer (ListNode[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }
    return divideAndConq(lists, 0, lists.length - 1);
  }

  public static ListNode divideAndConq(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }

    if (start < end) {
      int mid = start + (end - start) / 2;
      ListNode left = divideAndConq(lists, start, mid);
      ListNode right = divideAndConq(lists, mid + 1, end);
      return merge(left, right);
    }

    return null;
  }

  public static ListNode merge(ListNode left, ListNode right) {
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

  public static ListNode mergeKListsUsingHeap (ListNode[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (ListNode head : lists) {
      ListNode node = head;
      while (node != null) {
        queue.add(node.val);
        node = node.next;
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;

    while (!queue.isEmpty()) {
      Integer val = queue.poll();
      cur.next = new ListNode(val);
      cur = cur.next;
    }

    return dummy.next == null ? null : dummy.next;
  }

}
