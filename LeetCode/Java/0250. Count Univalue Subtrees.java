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
    int ans;
    private int traverse(TreeNode root) {
        if (root == null) {
            return -1001;
        }
        int l = traverse(root.left);
        int r = traverse(root.right);
        if ((l == -1001 || l == root.val) &&
            (r == -1001 || r == root.val)) {
                ans +=1;
                return root.val;
            }
        // int l = root.left == null ? -1001 : traverse(root.left);
        // int r = root.right == null ? -1001 : traverse(root.right);
        // if (l == -1001) {
        //     l = r;
        // }
        // if (r == -1001) {
        //     r = l;
        // }
        // if (l == r) {
        //     if (l == -1001 || l == root.val) {
        //         ans +=1;
        //         return root.val;
        //     }
        // }
        return 1001;
    }
    public int countUnivalSubtrees(TreeNode root) {
        ans = 0;
        if (root != null) {
            int temp = traverse(root);
        }
        return ans;
    }
}
