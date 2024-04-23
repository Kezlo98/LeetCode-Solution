package com.leetcode.solution;

import com.leetcode.solution.validateBST.TreeNode;

public class _129_SumRootToLeaf {
    /*
        You are given the root of a binary tree containing digits from 0 to 9 only.

        Each root-to-leaf path in the tree represents a number.

        For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
        Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

        A leaf node is a node with no children.



        Example 1:


        Input: root = [1,2,3]
        Output: 25
        Explanation:
        The root-to-leaf path 1->2 represents the number 12.
        The root-to-leaf path 1->3 represents the number 13.
        Therefore, sum = 12 + 13 = 25.
        Example 2:


        Input: root = [4,9,0,5,1]
        Output: 1026
        Explanation:
        The root-to-leaf path 4->9->5 represents the number 495.
        The root-to-leaf path 4->9->1 represents the number 491.
        The root-to-leaf path 4->0 represents the number 40.
        Therefore, sum = 495 + 491 + 40 = 1026.


        Constraints:

        The number of nodes in the tree is in the range [1, 1000].
        0 <= Node.val <= 9
        The depth of the tree will not exceed 10.
     */

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, node3);

        int i = sumNumbers(node1);

        System.out.printf("Result: " + i);
    }

    public static int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        numberFromRootToLeaf(root, "", sum);
        return sum[0];
    }

    public static void numberFromRootToLeaf(TreeNode node, String stringNumber, int[] sum) {
        stringNumber = stringNumber + node.val;
        if(node.left != null) {
            numberFromRootToLeaf(node.left, stringNumber, sum);
        }
        if(node.right != null) {
            numberFromRootToLeaf(node.right, stringNumber, sum);
        }
        if(node.left == null && node.right == null){
            sum[0] = sum[0] + Integer.parseInt(stringNumber);
        }
    }
}
