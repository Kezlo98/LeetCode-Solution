package src.com.leetcode.solution;

import src.com.leetcode.solution.validateBST.TreeNode;

import java.util.Arrays;

public class _106_ContructBinaryTreeFromInorderAndPostorderTraversal {
    /*
        Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



        Example 1:


        Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        Output: [3,9,20,null,null,15,7]
        Example 2:

        Input: inorder = [-1], postorder = [-1]
        Output: [-1]


        Constraints:

        1 <= inorder.length <= 3000
        postorder.length == inorder.length
        -3000 <= inorder[i], postorder[i] <= 3000
        inorder and postorder consist of unique values.
        Each value of postorder also appears in inorder.
        inorder is guaranteed to be the inorder traversal of the tree.
        postorder is guaranteed to be the postorder traversal of the tree.
     */
    public static void main(String[] args) {
        int[] inorder = {1,2,3,4};
        int[] postorder = {2,1,4,3};

        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.printf("Result");
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] rootIndex = {0};
        return buildTree(inorder,postorder,rootIndex);


    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int[] rootIndex) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        int value = postorder[postorder.length-rootIndex[0]-1];
        rootIndex[0] = rootIndex[0] + 1;
        if(inorder.length == 1 ){
            return new TreeNode(inorder[0]);
        }
        int mid = findIndexOfElement(inorder, value);
        TreeNode root = new TreeNode(value);

        root.right = buildTree(
                Arrays.copyOfRange(inorder, mid+1, inorder.length),
                postorder,rootIndex);
        root.left = buildTree(
                Arrays.copyOfRange(inorder, 0, mid),
                postorder,rootIndex);

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
}
