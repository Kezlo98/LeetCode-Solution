import com.leetcode.solution.validateBST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_BinaryTreeRightSideView {
    /*
        Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



        Example 1:


        Input: root = [1,2,3,null,5,null,4]
        Output: [1,3,4]
        Example 2:

        Input: root = [1,null,3]
        Output: [1,3]
        Example 3:

        Input: root = []
        Output: []


        Constraints:

        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100
     */

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2,node4,null);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1,node2,node3);

        List<Integer> integers = rightSideView(node1);

        for (int i = 0; i < integers.size(); i++) {
            System.out.printf(" " + integers.get(i));

        }
    }

    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            TreeNode node;
            for(int i = 0; i < n; i ++){
                node = queue.poll();
                if(i == 0){
                    result.add(node.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
            }
        }
        return result;
    }
}
