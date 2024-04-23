package com.leetcode.solution;

import com.leetcode.solution.validateBST.TreeNode;

public class _230_kthSmallestElementInaBST {
    /*
        Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



        Example 1:


        Input: root = [3,1,4,null,2], k = 1
        Output: 1
        Example 2:


        Input: root = [5,3,6,2,4,null,null,1], k = 3
        Output: 3


        Constraints:

        The number of nodes in the tree is n.
        1 <= k <= n <= 104
        0 <= Node.val <= 104


        Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
     */

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2,_1,null);

        TreeNode _4 = new TreeNode(4);

        TreeNode _3 = new TreeNode(3,_2,_4);

        TreeNode _6 = new TreeNode(6);

        TreeNode _5 = new TreeNode(5,_3,_6);

        System.out.println("Result: " + kthSmallest(_5,4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        return findKthSmallest(root, count, k);
    }

    public static int findKthSmallest(TreeNode node, int[] count, int k){
        if(node == null){
            return -1;
        }
        int left = findKthSmallest(node.left, count, k);
        if( left != -1){
            return left;
        }
        count[0]++;
        if(count[0] == k){
            return node.val;
        }
        int right = findKthSmallest(node.right, count, k);
        if( right != -1){
            return right;
        }
        return -1;

    }
}
