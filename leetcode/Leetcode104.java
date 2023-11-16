class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: If the root is null, the depth is 0.
        if (root == null) {
            return 0;
        }

        // Recursive case: Calculate the depth of the left and right subtrees.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth of the left or right subtree, plus 1 for the current node.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
