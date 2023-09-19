/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    TreeNode dfs(TreeNode node, TreeNode[] nodes) {
        if (node == null) {
            return node;
        }
        for (TreeNode t : nodes) {
            if (t == node) {
                return node;
            }
        }
        TreeNode left = dfs(node.left, nodes);
        TreeNode right = dfs(node.right, nodes);
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        int n = nodes.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return nodes[0];
        }
        return dfs(root, nodes);
    }
}
// compare the whole array every time
// if array too big, need hashset?

// intuition idea, run dfs for every two
// class Solution {
//     TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
//         if (node == null || node == p || node == q) {
//             return node;
//         }
//         TreeNode left = dfs(node.left, p, q);
//         TreeNode right = dfs(node.right, p, q);
//         if (left == null || right == null) {
//             return left == null ? right : left;
//         }
//         return node;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
//         int n = nodes.length;
//         if (n == 0) {
//             return null;
//         }
//         if (n == 1) {
//             return nodes[0];
//         }

//         TreeNode ans = nodes[0];
//         for (int i = 1; i < n; i++) {
//             ans = dfs(root, ans, nodes[i]);
//         }
//         return ans;
//     }
// }
