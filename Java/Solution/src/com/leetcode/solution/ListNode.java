package src.com.leetcode.solution;

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

    public void printListNode(){
        ListNode curNode = this;
        while (curNode != null){
            System.out.printf(curNode.val + "  ");
            curNode = curNode.next;
        }
    }
}
