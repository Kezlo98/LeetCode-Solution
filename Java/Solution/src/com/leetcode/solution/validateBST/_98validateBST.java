package com.leetcode.solution.validateBST;

public class _98validateBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.printf("Valid BST: " + isValidBST(root,null,null));
    }

    // BFS
    public static boolean isValidBST(TreeNode node, Integer lowerLimit, Integer upperLimit){
        if(node == null){
            return true;
        }

        if(lowerLimit != null && node.val <= lowerLimit){
            return false;
        }

        if(upperLimit != null && node.val >= upperLimit){
            return false;
        }

        if(!isValidBST(node.left,lowerLimit,node.val)){
            return false;
        }

        return isValidBST(node.right, node.val, upperLimit);
    }

}
