package src.com.leetcode.solution;

import src.com.leetcode.solution.validateBST.TreeNode;

public class _235_LowestCommonAncestorOfABinarySearchTree {
    /*
        Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



        Example 1:


        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        Output: 6
        Explanation: The LCA of nodes 2 and 8 is 6.
        Example 2:


        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        Output: 2
        Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
        Example 3:

        Input: root = [2,1], p = 2, q = 1
        Output: 2


        Constraints:

        The number of nodes in the tree is in the range [2, 105].
        -109 <= Node.val <= 109
        All Node.val are unique.
        p != q
        p and q will exist in the BST.
     */

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);
        TreeNode _4 = new TreeNode(4,_3,_5);

        TreeNode _0 = new TreeNode(0);
        TreeNode _2 = new TreeNode(2,_0,_4);

        TreeNode _7 = new TreeNode(7);
        TreeNode _9 = new TreeNode(9);
        TreeNode _8 = new TreeNode(8, _7, _9);

        TreeNode _6 = new TreeNode(6, _2, _8);

        TreeNode result = lowestCommonAncestor(_6, _2, _4);

        System.out.println("Result: " + result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left;
        TreeNode right;

        if(root.val < p.val && root.val < q.val){
            right = lowestCommonAncestor(root.right,p,q);
            if(right != null){
                return right;
            }
            return root;
        } else if (root.val > p.val && root.val > q.val){
            left = lowestCommonAncestor(root.left,p,q);
            if(left != null){
                return left;
            }
            return root;
        } else {
            right = lowestCommonAncestor(root.right,p,q);
            left = lowestCommonAncestor(root.left,p,q);
            if(left != null && right != null){
                return root;
            }
            if(left != null){
                return left;
            }

            if(right != null){
                return right;
            }
        }

        return null;
    }
}
