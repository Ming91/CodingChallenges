// Top Interview 150 Binary Tree General Q1
// LeetCode 75 Binary Tree - DFS Q1
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
// Top Interview 150 09/22/2023
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// class Solution {
//     // int depth = 0;
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int l = maxDepth(root.left);
//         int r = maxDepth(root.right);
//         return Math.max(l, r) + 1;
//     }
// }
