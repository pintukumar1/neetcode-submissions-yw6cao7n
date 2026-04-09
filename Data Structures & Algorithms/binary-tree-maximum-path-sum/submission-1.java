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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);

        int nodeSum = node.val + leftSum + rightSum;
        maxValue = Math.max(maxValue, nodeSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
