// Top Interview 150 Binary Tree General Q6
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
    int i;
    int p;
    int n;
    TreeNode build(int[] inorder, int[] postorder, int stop) {
        if (p == -1) {
            return null;
        }
        if (inorder[i] == stop) {
            i--;
            return null;
        }
        int curr = postorder[p--];
        TreeNode root = new TreeNode(curr);
        root.right = build(inorder, postorder, curr);
        root.left = build(inorder, postorder, stop);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        n = inorder.length;
        i = n - 1;
        p = n - 1;
        return build(inorder, postorder, 3_001);
    }
}
// same problem as problem 105.
