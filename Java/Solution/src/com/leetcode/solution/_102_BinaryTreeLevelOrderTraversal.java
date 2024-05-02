package src.com.leetcode.solution;

import src.com.leetcode.solution.validateBST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal {
    /*
        Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



        Example 1:


        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[9,20],[15,7]]
        Example 2:

        Input: root = [1]
        Output: [[1]]
        Example 3:

        Input: root = []
        Output: []


        Constraints:

        The number of nodes in the tree is in the range [0, 2000].
        -1000 <= Node.val <= 1000
     */

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        BFS(root,result);
        return result;
    }

    public void BFS(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i ++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
    }
}
