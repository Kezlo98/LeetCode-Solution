package com.leetcode.solution;

import java.util.Arrays;

public class _105_ContructBinaryTreeFromPreorderAndInorderTraversal {

    /*
        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



        Example 1:


        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]
        Example 2:

        Input: preorder = [-1], inorder = [-1]
        Output: [-1]


        Constraints:

        1 <= preorder.length <= 3000
        inorder.length == preorder.length
        -3000 <= preorder[i], inorder[i] <= 3000
        preorder and inorder consist of unique values.
        Each value of inorder also appears in preorder.
        preorder is guaranteed to be the preorder traversal of the tree.
        inorder is guaranteed to be the inorder traversal of the tree.
     */

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

        System.out.printf("Hold");
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = findIndexOfElement(inorder, preorder[0]);
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }

    public static int findIndexOfElement(int[] array, int element){
        for (int i = 0; i < array.length; i ++){
            if(array[i] == element){
                return i;
            }
        }

        return 0;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
