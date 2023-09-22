// Top Interview 150 Binary Tree General Q4
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
    boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
}
// [Editorial] Use isMirror is better.

// [Ming] Use two previous problem to solve.
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) {
//             return true;
//         }
//         if (p == null || q == null) {
//             return false;
//         }
//         if (p.val != q.val) {
//             return false;
//         }
//         return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
//     }
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         TreeNode temp = invertTree(root.left);
//         root.left = invertTree(root.right);
//         root.right = temp;
//         return root;
//     }

//     public boolean isSymmetric(TreeNode root) {
//         return isSameTree(root.left, invertTree(root.right));
//     }
// }
