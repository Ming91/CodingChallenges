// Top Interview 150 Binary Tree BFS Q4
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
    void dfs(List<List<Integer>> ans, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() == depth) {
            ans.add(new ArrayList<>());
        }
        if ((depth & 1) == 1) {
            ans.get(depth).add(0, root.val);
        } else {
            ans.get(depth).add(root.val);
        }
        dfs(ans, root.left, depth + 1);
        dfs(ans, root.right, depth + 1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }
}
