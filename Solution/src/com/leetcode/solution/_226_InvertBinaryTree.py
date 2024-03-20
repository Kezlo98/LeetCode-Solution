"""
Given the root of a binary tree, invert the tree, and return its root.

EX 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

EX 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []

"""


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def invert_tree(self, root):
        if not root:
            return root
        root.left, root.right = root.right, root.left

        self.invert_tree(root.left)
        self.invert_tree(root.right)

        return root


if __name__ == '__main__':
    _1 = TreeNode(1)
    _3 = TreeNode(3)
    _2 = TreeNode(2, _1, _3)
    _6 = TreeNode(6)
    _9 = TreeNode(9)
    _7 = TreeNode(7, _6, _9)
    _4 = TreeNode(4, _2, _7)

    solution = Solution()
    tree = solution.invert_tree(_4)
    print("Inverted tree:")
