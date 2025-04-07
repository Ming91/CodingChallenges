// LeetCode 75 Binary Tree - DFS Q3
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
    int dfs(TreeNode curr, int upper) {
        if (curr == null) {
            return 0;
        }
        int ans = 0;
        if (curr.val >= upper) {
            upper = curr.val;
            ans++;
        }
        ans += dfs(curr.left, upper);
        ans += dfs(curr.right, upper);
        return ans;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
