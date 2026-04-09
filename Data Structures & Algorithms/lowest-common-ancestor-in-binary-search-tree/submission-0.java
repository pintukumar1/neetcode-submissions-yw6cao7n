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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            return left;
        } else if(p.val > root.val && q.val > root.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return right;
        } else {
            return root;
        }
    }
}
