package src.com.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode{
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

  public static TreeNode convertArrayInLevelOrderToTree(Integer[] array){
    return convertListInLevelOrderToTree(Arrays.asList(array));
  }

  public static TreeNode convertListInLevelOrderToTree(List<Integer> list) {
    if (list == null || list.isEmpty() || list.getFirst() == null) return null;

    TreeNode root = new TreeNode(list.getFirst());
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int index = 1;
    while (!queue.isEmpty() && index < list.size()) {
      TreeNode currentNode = queue.poll();

      // Add left child if not null
      if (index < list.size() && list.get(index) != null) {
        currentNode.left = new TreeNode(list.get(index));
        queue.offer(currentNode.left);
      }
      index++;

      // Add right child if not null
      if (index < list.size() && list.get(index) != null) {
        currentNode.right = new TreeNode(list.get(index));
        queue.offer(currentNode.right);
      }
      index++;
    }

    return root;
  }
}
