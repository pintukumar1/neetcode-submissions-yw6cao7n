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
    int[] inorder;
    int[] preorder;
    Map<Integer, Integer> map;
    int preIndex = 0; 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        map = new HashMap<>();

        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode node = helper(0, preorder.length - 1);
        return node;
    }

    public TreeNode helper(int left, int right) {
        if(left>right) {
            return null;
        }

        int rootValue = preorder[preIndex++];
        TreeNode node = new TreeNode(rootValue);

        int index = map.get(rootValue);

        node.left = helper(left, index-1);
        node.right = helper(index+1, right);

        return node;
    }
}
