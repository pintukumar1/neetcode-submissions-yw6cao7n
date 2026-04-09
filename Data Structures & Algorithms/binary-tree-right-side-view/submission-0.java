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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        helper(root, 0, result);
        return result;
    }

    public void helper(TreeNode node, int depth, List<Integer> result) {
        if(node == null) return;

        if(result.size() == depth) {
            result.add(node.val);
        }

        helper(node.right, depth+1, result);
        helper(node.left, depth+1, result);
    }
}
       
