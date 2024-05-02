package src.com.leetcode.solution;

import src.com.leetcode.solution.validateBST.TreeNode;

public class _114_FlattenBinaryTreeToLinkedList {
    /*
        Given the root of a binary tree, flatten the tree into a "linked list":

        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.


        Example 1:


        Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]
        Example 2:

        Input: root = []
        Output: []
        Example 3:

        Input: root = [0]
        Output: [0]

9
        Constraints:

        The number of nodes in the tree is in the range [0, 2000].
        -100 <= Node.val <= 100


        Follow up: Can you flatten the tree in-place (with O(1) extra space)?
     */

    public static void main(String[] args) {
//        TreeNode _4 = new TreeNode(4);
//        TreeNode _3 = new TreeNode(3);
//        TreeNode _2 = new TreeNode(2,_3,_4);
//
//        TreeNode _6 = new TreeNode(6);
//        TreeNode _5 = new TreeNode(5,null,_6);
//
//        TreeNode _1 = new TreeNode(1,_2,_5);

        TreeNode _2 = new TreeNode(2);
        TreeNode _1 = new TreeNode(1,_2,null);
        flatten(_1);
        System.out.println("Finish");
    }

    public static void flatten(TreeNode root) {
        flattenToRight(root, null);

    }

    private static void flattenByInOrder(TreeNode root){
        TreeNode curr = root;

        while (curr != null){
            if(curr.left != null){
                TreeNode running = curr.left;
                while (running.right != null) running = running.right;
                running.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    private static TreeNode flattenToRight(TreeNode node, TreeNode rightestNode){

        if(node == null){
            return rightestNode;
        }
        if(rightestNode == null){
            rightestNode = node;
        }

        if(node.left != null){
            rightestNode = node.left;
        }

        rightestNode = flattenToRight(node.left,rightestNode);

        if(node.right != null){
            rightestNode.right = node.right;
            if(node.left != null) {
                node.right = node.left;
            }
            node.left = null;
            rightestNode = rightestNode.right;
        } else {
            if(node.left != null) {
                node.right = node.left;
            }
            node.left = null;
            return rightestNode;
        }

        return flattenToRight(rightestNode,rightestNode);

    }
}
