// Top Interview 150 Binary Search Tree Q2
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
    int k;
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        this.k = k;
        dfs(root);
        return ans;
    }
}
// Follow-up Question: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
//  [Editorial] Given answer is like a b+ tree. 
//   Maintain a bidirectional list of all node (and in order). Each tree node point to corresponding node of the list. 
//   So we can find k-th smallest element using the list. 
