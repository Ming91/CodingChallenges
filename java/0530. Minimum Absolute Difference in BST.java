// Top Interview 150 Binary Search Tree Q1
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
    TreeNode prev;
    int ans;
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            ans = Math.min(ans, root.val - prev.val);
        }
        prev = root;
        dfs(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
}
// [Editorial]
//  Use inorder traversal with prev to solve. 


// [Ming] use leftmax and rightmin to solve 
// class Solution {
//     int ans = Integer.MAX_VALUE;
//     int[] dfs(TreeNode root) {
//         int[] left = root.left == null ? new int[] {root.val, root.val} : dfs(root.left);
//         int[] right = root.right == null ? new int[] {root.val, root.val} : dfs(root.right);
//         ans = root.left == null ? ans : Math.min(ans, root.val - left[1]);
//         ans = root.right == null ? ans : Math.min(ans, right[0] - root.val);
//         return new int[] {left[0], right[1]};
//     }
//     public int getMinimumDifference(TreeNode root) {
//         dfs(root);
//         return ans;
//     }
// }
