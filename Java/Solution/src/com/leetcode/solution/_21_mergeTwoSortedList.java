package src.com.leetcode.solution;

public class _21_mergeTwoSortedList {
    /*
        You are given the heads of two sorted linked lists list1 and list2.

        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

        Return the head of the merged linked list.



        Example 1:


        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]
        Example 2:

        Input: list1 = [], list2 = []
        Output: []
        Example 3:

        Input: list1 = [], list2 = [0]
        Output: [0]
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(
                1,new ListNode(
                        2,new ListNode(4)
        )
        );

        ListNode listNode2 = new ListNode(
                1,new ListNode(
                3,new ListNode(4)
        )
        );
        ListNode result = mergeTwoLists(listNode1,listNode2);
        System.out.print("Result:\n");
        while (result != null){
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode next = result;

        while (list1 != null || list2 != null){
            if(list1 == null){
                next.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null){
                next.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if(list1.val <= list2.val){
                    next.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    next.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }

            next = next.next;
        }

        return result.next;
    }

}
