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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean isValid =  helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }

    public boolean helper(TreeNode node, int minValue , int maxValue) {
        if(node == null) return true;

        if(node.val <= minValue ||  node.val >= maxValue) {
            return false;
        }

        boolean left = helper(node.left, minValue, node.val);
        boolean right = helper(node.right, node.val, maxValue);

        return left && right;
    }
}
