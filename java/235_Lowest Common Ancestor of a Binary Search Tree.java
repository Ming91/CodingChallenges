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
    TreeNode dfs(TreeNode node, int min, int max) {
        // 同下,搜索树不需要比较,只用考虑大小关系即可
        // LCA此时为,从上到下,第一个在min~max之间的node
        // if (node == null || node.val == min || node.val == max) {
        //     return node;
        // }
        if (node.val > max) {
            return dfs(node.left, min, max);
        }
        if (node.val < min) {
            return dfs(node.right, min, max);
        }
        // 其实下面都不需要,是之前普通二叉树需要的
        // 如果node.val在min和max中间,说明就是split point,即结果
        // TreeNode left = dfs(node.left, min, max);
        // TreeNode right = dfs(node.right, min, max);
        // // 之前code是left和right的val同min和max比较,
        // // 但是会有null,必须先考虑null,
        // // 但是不为null也不用比较了,左右都不为null,必定和对应val相等
        // if (left == null || right == null) {
        //     return left == null ? right : left;
        // }
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val < q.val ? p.val : q.val;
        int max = p.val > q.val ? p.val : q.val;
        return dfs(root, min, max);
    }
}
