// Top Interview 150 Binary Tree General Q8
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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) ) {
            return ;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
                continue;
            }
            TreeNode rightmost = curr.left;
            while (rightmost.right != null) {
                rightmost = rightmost.right;
            }
            rightmost.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;
        }
    }
}
// [Editorial] Iterative solution with O(1) space. 

// [Ming] solve the problem recursively. Still considered as O(n) space if think of recursion stack. 
// class Solution {
//     public void flatten(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         if (root.left != null) {
//             flatten(root.left);
//         }
//         flatten(root.right);
//         if (root.left == null) {
//             return ;
//         }
//         TreeNode curr = root.left;
//         TreeNode prev = root;
//         while (curr != null) {
//             prev = curr;
//             curr = curr.right;
//         }
//         prev.right = root.right;
//         root.right = root.left;
//         root.left = null;
//     }
// }
