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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int queueSize = queue.size();

            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<queueSize; i++) {
                TreeNode deleted = queue.poll();
                temp.add(deleted.val);

                if(deleted.left != null) {
                    queue.add(deleted.left);
                }
                if(deleted.right != null) {
                    queue.add(deleted.right);
                }
            }
            result.add(temp);
        }

        return result;

    }
}
