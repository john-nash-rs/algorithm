/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        return generateTrees(N, memo);
    }

    private List<TreeNode> generateTrees(int n, Map<Integer, List<TreeNode>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int leftNodes = 0; leftNodes < n; leftNodes++) {
                int rightNodes = n - 1 - leftNodes;
                for (TreeNode left : generateTrees(leftNodes, memo)) {
                    for (TreeNode right : generateTrees(rightNodes, memo)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}
