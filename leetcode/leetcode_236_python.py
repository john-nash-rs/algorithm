# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
         # Base case: If the root is None or matches either p or q, return root
        if not root or root.val == p.val or root.val == q.val:
            return root

        # Recursively search in the left and right subtrees
        left_lca = self.lowestCommonAncestor(root.left, p, q)
        right_lca = self.lowestCommonAncestor(root.right, p, q)

        # If both nodes are found in different subtrees, then the current root is the LCA
        if left_lca and right_lca:
            return root

        # If one node is found, return that node as the potential LCA
        return left_lca if left_lca else right_lca
        
