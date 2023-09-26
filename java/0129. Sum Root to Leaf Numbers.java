// Top Interview Binary Tree General Q10
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
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        int res = 0;
        TreeNode rightmost = null;
        int step = 0;
        while (root != null) {
            if (root.left == null) {
                res = res * 10 + root.val;
                if (root.right == null) {
                    ans += res;
                }
                root = root.right;
                continue;
            }
            rightmost = root.left;
            step = 1;
            while (rightmost.right != null && rightmost.right != root) {
                rightmost = rightmost.right;
                step++;
            }
            // if reach rightmost first time, link to root
            if (rightmost.right == null) {
                rightmost.right = root;
                res = res * 10 + root.val;
                root = root.left;
                continue;
            }
            // if reach rightmost second time, unlink
            // if rightmost.left == null, means rightmost is leaf, add to ans
            // res is updated first time in root.left == null part. 
            if (rightmost.left == null) {
                ans += res;
            }
            // go back to root, and reset res to root. 
            while (step > 0) {
                res /= 10;
                step--;
            }
            root = root.right;
            rightmost.right = null;
        }
        return ans;
    }
}

// [Editorial] Morris Algo --- Traversal with O(1) space
//  Link right most to root, if alread linked to root, unlink it. 
//  So node with left child will be visited twice (link and unlink), o/w just once. 
//  **Brilliant idea, just need to think clearly by self.
//  [Practice More]

// [Ming] Recursion Impl
// class Solution {
//     int calc(TreeNode curr, int res) {
//         if (curr == null) {
//             return 0;
//         }
//         if (curr.left == null && curr.right == null) {
//             return res * 10 + curr.val;
//         }
//         return calc(curr.left, res * 10 + curr.val) + calc(curr.right, res * 10 + curr.val);
//     }
//     public int sumNumbers(TreeNode root) {
//         return calc(root, 0);
//     }
// }
